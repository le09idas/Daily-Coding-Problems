//binaryLeafSum.java

class Node
{
    int value;
    Node left;
    Node right;

    public Node(int val)
    {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public void addChild(Node child)
    {
        if(this.value >= child.value)
        {
            if(this.right == null)
            {
                this.right = child;
            }
            else
            {
                this.right.addChild(child);
            }
        }
        else
        {
            if(this.left == null)
            {
                this.left = child;
            }
            else
            {
                this.left.addChild(child);
            }
        }
    }

    public String toString()
    {
        return "" + this.value;
    }
}//end class Node

class Tree
{
    Node root;

    public Tree(Node r)
    {
        this.root = r;
    }

    public addLeaf(Node leaf)
    {
        this.root.addChild(leaf);
    }

    public Node[] getLeafDuet(int k, Node pivot)
    {
        Node [] duet = new Node[2];

        

        return duet;

    }
}

