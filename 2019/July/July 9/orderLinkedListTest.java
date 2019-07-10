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

class NodeSorter
{
    public static Node mergeSort(Node start, int seg)
    {
        if(seg == 1)
        {
            start.next = null;
            return start;
        }
        else if(seg == 2)
        {
            if(start.value <= start.next.value)
            {
                start.next = null;
                return start;
            }
            else
            {
                Node temp = start.next;
                start.next = null;
                temp.next = start;
                return temp;
            }
        }
        else
        {
            int piv = 0;
            Node ptr = start;

            while(piv <= seg/2)
            {
                ptr = ptr.next;
                piv++;
            }

            Node sublist1 = mergeSort(start, seg/2 + seg%2);
            Node sublist2 = mergeSort(ptr.next, seg - seg/2 - seg%2);


            Node fuser = null;
            Node fused = null;

            if(sublist1.value <= sublist2.value)
            {
                fused = sublist1;
                sublist1 = sublist1.next;
            }
            else
            {
                fused = sublist2;
                sublist2 = sublist2.next;
            }

            fuser = fused;

            while(sublist1 != null && sublist2 != null)
            {
                if(sublist1.value <= sublist2.value)
                {
                    fuser.next = sublist1;
                    sublist1 = sublist1.next;
                }
                else
                {
                    fuser.next = sublist2;
                    sublist2 = sublist2.next;
                }
                fuser = fuser.next;
            }

            if(sublist1 != null)
            {
                fuser.next = sublist1;
            }
            else if(sublist2 != null)
            {
                fuser.next = sublist2;
            }

            return fused;
        }
    }
}

class TestApp
{
    public static void main(String[] args)
    {
        Node one = new Node(4);
        Node two = new Node(1);
        Node three = new Node(-3);
        //Node four = new Node(99);
        //Node five = new Node(5);
        //Node six = new Node(6);

        one.next = two;
        two.next = three;
        //three.next = four;
        //four.next = five;
        //five.next = six;

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

        Node sorted = NodeSorter.mergeSort(one, 3);

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