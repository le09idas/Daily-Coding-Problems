//inorderSuccessorApp.java

class TreeNode
{
    int value;
    TreeNode parent;
    TreeNode lChild;
    TreeNode rChild;

    public TreeNode(int val)
    {
        this.value = val;
        this.parent = null;
        this.lChild = null;
        this.rChild = null;
    }
}//end TreeNode

class BinaryTree
{
    TreeNode root;

    public BinaryTree(TreeNode r)
    {
        this.root = r;
    }

    public void addChild(TreeNode c, TreeNode ptr)
    {
        if(c.value < ptr.value)
        {
            if(ptr.lChild == null)
            {
                ptr.lChild = c;
                c.parent = ptr;
                return;
            }
            addChild(c, ptr.lChild);
            return;
        }
        if(c.value > ptr.value)
        {
            if(ptr.rChild == null)
            {
                ptr.rChild = c;
                c.parent = ptr;
                return;
            }
            addChild(c, ptr.rChild);
            return;
        }
        else
        {
            System.out.println("No duplicates allowed");
        }
    }

    public boolean search(int key, TreeNode node)
    {
        
        if(key == node.value)
        {
            return true;
        }
        else
        {
            if(key < node.value)
            {
                if(node.lChild == null)
                {
                    return false;
                }
                else
                {
                    return search(key, node.lChild);
                }
            }
            if(key > node.value)
            {
                if(node.rChild == null)
                {
                    return false;
                }
                else
                {
                    return search(key, node.rChild);
                }
            }
        }
        return false;
    }

    public Object inorderSuccessor(TreeNode ancestor)
    {
        if(ancestor.rChild == null)
        {
            if(ancestor.parent == null || ancestor.parent.value < ancestor.value)
            {
                System.out.println("No successors");
                return null;
            }
            else
            {
                return ancestor.parent.value;
            }
        }
        else
        {
            return ancestor.rChild.value;
        }
    }
}//end BinaryTree

class TestApp
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        TreeNode leaf1 = new TreeNode(5);
        TreeNode leaf2 = new TreeNode(30);
        TreeNode leaf3 = new TreeNode(22);
        TreeNode leaf4 = new TreeNode(35);

        BinaryTree tree = new BinaryTree(root);
        tree.addChild(leaf1, tree.root);
        tree.addChild(leaf2, tree.root);
        tree.addChild(leaf3, tree.root);
        tree.addChild(leaf4, tree.root);

        System.out.println(tree.search(15, tree.root));
        System.out.println(tree.inorderSuccessor(leaf2));
        
    }
}