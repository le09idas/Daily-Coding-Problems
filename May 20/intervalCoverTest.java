//intervalCoverTest
class Node
{
    int lowLim;
    int highLim;

    Node prev;
    Node next;

    public Node(int low, int high)
    {
        this.lowLim = low;
        this.highLim = high;
        this.prev = null;
        this.next = null;
    }

    public String toString()
    {
        return "[" + Integer.toString(this.lowLim)
                + "," + Integer.toString(this.highLim)
                + "]";
    }
}//end Node class

class List
{
    Node head;
    int lowExtreme;
    int highExtreme;

    public List(Node head)
    {
        this.head = head;
        this.lowExtreme = head.lowLim;
        this.highExtreme = head.highLim;
    }

    public void addInterval(Node interval)
    {
        Node ptr = this.head;

        while(ptr != null) //travel list
        {
            
        }
        
    }
}
class TestApp
{
    public static void main(String[] args)
    {
        Node one = new Node(1,2);
        Node two = new Node(2,2);
        Node three = new Node(2,1);
        
        List list = new List(one);
        list.addInterval(two);
        list.addInterval(three);

        Node curr = list.head;
        while(curr != null)
        {
            System.out.println(curr.toString());
            curr = curr.next;
        }
    }

}//end TestApp