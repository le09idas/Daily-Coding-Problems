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

    int numIntervals;
    int lowExtreme;
    int highExtreme;

    public List(Node head)
    {
        this.head = head;

        this.numIntervals = 1;
        this. lowExtreme = head.lowLim;
        this.highExtreme = head.highLim;
    }

    public void addInterval(Node interval)
    {
        if(interval.lowLim < lowExtreme)
        {
            interval.next = this.head;
            this.head.prev = interval;
            this.head = interval;

            this.lowExtreme = this.head.lowLim;
        }
        else
        {
            Node temp = this.head.next;

            while(interval.lowLim > temp.lowLim)
            {
                if(temp.next == null)
                {
                    temp.next = interval;
                    if(interval.highLim > this.highExtreme)
                        this.highExtreme = interval.highLim;
                    break;
                }
                temp = temp.next;
            }

            interval.prev = temp.prev;
            temp.prev = interval;
            interval.next = temp;
        }
        this.numIntervals++;
    }
}
class TestApp
{
    public static void main(String[] args)
    {
        Node one = new Node(1,2);
        Node two = new Node(2,2);
        
        List list = new List(one);
        list.addInterval(two);

        Node curr = list.head;
        while(curr != null)
        {
            System.out.println(one.toString());
            curr = curr.next;
        }
    }

}//end TestApp