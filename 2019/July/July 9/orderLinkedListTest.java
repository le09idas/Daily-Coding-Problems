//orderLinkedListTest.java

/*
    There's nothing really special about
    this Node class here
*/
class Node
{
    int value;
    Node next;

    public Node(int val)
    {
        this.value = val;
        this.next = null;
    }//end constructor

    public String toString()
    {
        return Integer.toString(this.value);
    }//end toString()
}//end Node class

/*
    This class just contains the method to mergeSort the
    linked list.
*/
class NodeSorter
{
    /*
        mergeSort() applies the merge sort algorithm
        to the linked list.  It takes in a node ptr 
        to a segments head and the length of the segment.
        It then divides until it gets segments that are the 
        bases cases.  It then returns those and merges the 
        subsequent sorted segments returned. start is the head
        of a linked list and seg is the number of nodes it 
        contains.
    */
    public static Node mergeSort(Node start, int seg)
    {
        if(seg == 1)                                //only one node
        {
            start.next = null;                      //no need for next since it is already referenced by another mergeSort op
            return start;
        }//end if
        else if(seg == 2)                           //two nodes
        {
            if(start.value <= start.next.value)     //no need to change the order
            {
                start.next.next = null;             //need to have this set so that no infinite loops are made
                return start;
            }//end if
            else
            {
                Node temp = start.next;
                start.next = null;
                temp.next = start;
                return temp;
            }//end else 
        }//end else if
        else                                        //more than two nodes 
        {
            int piv = 0;                            //where to split segment
            Node ptr = start;       

            while(piv < seg/2)      //while the piv is less than half the length
            {
                ptr = ptr.next;
                piv++;
            }//end while

            Node sublist1 = mergeSort(start, seg/2);        //This is the first half of a segment 
            Node sublist2 = mergeSort(ptr, seg - seg/2);    //This is the second half of a segment


            Node fuser = null;      //The tail of the combined list
            Node fused = null;      //The head of the combined list

            if(sublist1.value <= sublist2.value) //if node from sublist comes before the node from the other 
            {
                fused = sublist1;                //add its node to start off the return list
                sublist1 = sublist1.next;        //point to next node
            }//end if 
            else                                 //node from other sublist comes before sublist1
            {   
                fused = sublist2;                //start off return list with node
                sublist2 = sublist2.next;        //point to next node
            }//end else

            fuser = fused;                       //have fuser point to first node of return list

            while(sublist1 != null && sublist2 != null) //while both sublists have nodes
            {
                if(sublist1.value <= sublist2.value)    //node from sublist1 comes before node from sublist2    
                {
                    fuser.next = sublist1;
                    sublist1 = sublist1.next;
                }//end if
                else                                    //node from sublist2 comes before node from sublist1
                {
                    fuser.next = sublist2;
                    sublist2 = sublist2.next;
                }//end else
                fuser = fuser.next;
            }//end while

            if(sublist1 != null)        //append rest of sublist1
            {
                fuser.next = sublist1;
            }//end if
            else if(sublist2 != null)   //append rest of sublist2
            {
                fuser.next = sublist2;
            }//end else if

            return fused;
        }//end else
    }//end mergeSort()
}//end class NodeSorter

class TestApp
{
    public static void main(String[] args)
    {
        Node one = new Node(4);
        Node two = new Node(1);
        Node three = new Node(-3);
        Node four = new Node(99);
        Node five = new Node(5);
        Node six = new Node(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        Node ptr = one;

        System.out.println("Initial list;");

        while(ptr!=null)
        {
            System.out.print(ptr.toString());
            if(ptr.next != null)
            {
                System.out.print("->");
            }
            ptr = ptr.next;
        }
        System.out.println("");

        Node sorted = NodeSorter.mergeSort(one, 6);

        System.out.println("Sorted list:");

        while(sorted!=null)
        {
            System.out.print(sorted.toString());
            if(sorted.next != null)
            {
                System.out.print("->");
            }
            sorted = sorted.next;
        }
        System.out.println("");
    }
}