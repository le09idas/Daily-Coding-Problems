//orderLinkedListTest.java

class Node
{
    int value;
    Node next;

    public Node(int val)
    {
        this.value = val;
        this.next = null;
    }

    public String toString()
    {
        return Integer.toString(this.value);
    }
}

class TestApp
{
    public static void main(String[] args)
    {
        Node one = new Node(4);
        Node two = new Node(1);
        Node three = new Node(-3);
        Node four = new Node(99);

        one.next = two;
        two.next = three;
        three.next = four;

        Node ptr = one;
        while(ptr!=null)
        {
            System.out.print(ptr.toString());
            if(ptr.next != null)
            {
                System.out.print(print("->"));
            }
        }
        System.out.println("");
    }
}