import java.util.ArrayList;

//intervalCoverTest
class Set
{
    ArrayList<String> set;

    public Set() 
    {
        this.set = new ArrayList<String>();
    }//end constructor

    public void addElement(int e) 
    {

        for (int i = 0; i < this.set.size(); i++) 
        {
            if (this.set.get(i).compareTo(Integer.toString(e)) == 0) 
            {
                return;
            }//end if

        }//end for
        this.set.add(Integer.toString(e));

    }//end addElement

    public String toString() 
    {
        String displaySet = "{";

        int i = 0;

        if(this.set.size() == 0){
            ;
        }//end if
        else
        {
            displaySet = displaySet.concat(this.set.get(i));
            i++;

            while (i < this.set.size()) 
            {
                displaySet = displaySet.concat(", " + this.set.get(i));
                i++;
            }//end while
        }//end else

        displaySet = displaySet.concat("}");

        return displaySet;
    }//end toString
}//end set

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
    }//end constructor

    public boolean isSubset(Node target)
     {
        if(target == null)
        {
            return false;
        }
        if (this.lowLim >= target.lowLim 
        && this.highLim <= target.highLim) 
        {
            return true;
        }//end if
        else 
        {
            return false;
        }//end else
    }//end isSubset

    public boolean highIntersect(Node target) 
    {
        if(target == null)
        {
            return false;
        }
        if(this.highLim >= target.lowLim
        && this.highLim < target.highLim)
        {
            return true;
        }//end if
        return false;
    }//end highIntersect

    public boolean lowIntersect(Node target)
    {
        if(target == null)
        {
            return false;
        }
        if(this.lowLim >= target.lowLim
        && this.lowLim < target.highLim)
        {
            return true;
        }
        return false;
    }//end preIntersect

    public String toString() 
    {
        return "[" + Integer.toString(this.lowLim) + "," + Integer.toString(this.highLim) + "]";
    }//end toString
}// end Node class

class List 
{
    Node head;
    int length;
    int lowExtreme;
    int highExtreme;

    public List(Node head) 
    {
        this.head = head;
        this.length = 1;
        this.lowExtreme = head.lowLim;
        this.highExtreme = head.highLim;
    }//end constructor

    public void addInterval(Node interval) {
        Node ptr = this.head;

        while (ptr != null) {
            if (interval.lowLim <= ptr.lowLim) 
            {
                
                if (ptr.prev == null) 
                {
                    this.head = interval;
                    interval.next = ptr;
                    ptr.prev = interval;
                }//end if
                else 
                {
                    interval.prev = ptr.prev;
                    interval.next = ptr;
                    ptr.prev.next = interval;
                    ptr.prev = interval;
                }//end else
                this.length++;
                return;
            }//end if
            if (ptr.next == null) 
            {
                ptr.next = interval;
                interval.prev = ptr;
                this.length++;
                return;
            }//end if
            ptr = ptr.next;
        }//end while

    }//end addInterval

    public static Set findSmallestCover(List intervals) 
    {
        Set smallest = new Set();
        Node ptr = intervals.head;
        

        while(ptr != null)
        {
            Node scout = ptr.next;
            while(scout != null)
            {
                if(scout.isSubset(ptr) && !scout.highIntersect(scout.next))
                {
                    smallest.addElement(scout.highLim);
                    scout = scout.next;
                    continue;
                }
                else if(ptr.highIntersect(scout))
                {
                    scout = scout.next;
                    continue;
                }
                break;
            }
            Node revPtr = ptr.prev;
            while(revPtr != null)
            {
                if(ptr.lowIntersect(revPtr))
                {
                    break;
                }
                revPtr = revPtr.prev;
            }
            if(revPtr == null)
            {
                smallest.addElement(ptr.highLim);
            }
            
            
            ptr = ptr.next;

            
        }

        return smallest;
    }//end findSmallestCover

    public String toString()
    {
        String list = "";
        Node ptr = this.head;
        while(ptr != null)
        {
            list = list + ptr.toString() + "\n";
            ptr = ptr.next;
        }
        return list;
    }//end toString
}// end class List

class TestApp 
{
    public static void main(String[] args) 
    {
       
        Node zero = new Node(1,1);
        Node one = new Node(0,3);
        Node two = new Node(2,6);
        Node five = new Node(5,5);
        Node three = new Node(3,4);
        Node four = new Node(6,9);

        List l = new List(four);

        l.addInterval(zero);
        l.addInterval(one);
        l.addInterval(two);
        l.addInterval(three);
        l.addInterval(five);

        System.out.println(l.toString());

        Set s = List.findSmallestCover(l);

        System.out.println(s);

    }//end main

}// end TestApp
