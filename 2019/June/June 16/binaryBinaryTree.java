//binaryBinaryTree.java
class BinaryNode
{
    int val;
    boolean toTrim;
    BinaryNode leftChild;
    BinaryNode rightChild;

    public BinaryNode(int v)
    {
        this.val = v;
        this.toTrim = false;
        this.leftChild = null;
        this.rightChild = null;
    }

    public String toString()
    {
        String s = Integer.toString(this.val);
        if(this.leftChild != null)
        {
             s += this.leftChild.toString() + "/";
        }
        if(this.rightChild != null)
        {
           s += "\\" + this.rightChild.toString();
        }
        
        return s;
    }
}

class BinaryBinaryTree
{
    BinaryNode root;

    public BinaryBinaryTree(BinaryNode r)
    {
        this.root = r;
    }

    public void trimTree(BinaryNode leaf)
    {
        if(leaf.leftChild.toTrim)
        {
            leaf.leftChild = null;
        }
        if(leaf.rightChild.toTrim)
        {
            leaf.rightChild = null;
        }
        if(leaf.val == 0)
        {
            if(leaf.rightChild == null && leaf.leftChild == null)
            {
                leaf.toTrim = true;
            }
        }
    }

    public String toString()
    {
        return this.root.leftChild.toString() + "\n" + this.root.rightChild.toString();
    }
}

class TestApp
{
    public static void main(String[] args)
    {
        BinaryNode node0 = new BinaryNode(0);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(0);
        BinaryNode node3 = new BinaryNode(1);
        BinaryNode node4 = new BinaryNode(0);
        BinaryNode node5 = new BinaryNode(0);
        BinaryNode node6 = new BinaryNode(0);

        node0.leftChild = node1;
        node0.rightChild = node2;

        node2.leftChild = node3;
        node2.rightChild = node4;

        node4.leftChild = node5;
        node4.rightChild = node6;

        BinaryBinaryTree tree = new BinaryBinaryTree(node0);
        
        System.out.println(tree.toString());

        tree.trimTree(tree.root);

        System.out.println(tree.toString());

    }
}