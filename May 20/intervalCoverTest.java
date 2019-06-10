import java.util.ArrayList;

//intervalCoverTest
class Set {
    ArrayList<String> set;

    public Set() {
        this.set = new ArrayList<String>();
    }

    public void addElement(int e) {
        this.set.add(Integer.toString(e));
    }

    public String toString() {
        String displaySet = "{";

        int i = 0;

        displaySet = displaySet.concat(this.set.get(i));
        i++;

        while (i < this.set.size()) {
            displaySet = displaySet.concat(", " + this.set.get(i));
            i++;
        }

        displaySet = displaySet.concat("}");

        return displaySet;
    }
}

class Node {
    int lowLim;
    int highLim;

    Node prev;
    Node next;

    public Node(int low, int high) {
        this.lowLim = low;
        this.highLim = high;
        this.prev = null;
        this.next = null;
    }

    public String toString() {
        return "[" + Integer.toString(this.lowLim) + "," + Integer.toString(this.highLim) + "]";
    }
}// end Node class

class List {
    Node head;
    int lowExtreme;
    int highExtreme;

    public List(Node head) {
        this.head = head;
        this.lowExtreme = head.lowLim;
        this.highExtreme = head.highLim;
    }

    public void addInterval(Node interval) {
        Node ptr = this.head;

        while (ptr != null) {
            if (ptr.prev == null) {
                if (interval.lowLim < ptr.lowLim) {
                    this.head = interval;
                    this.head.next = ptr;
                    ptr.prev = this.head;
                }
                if (interval.lowLim == ptr.lowLim && interval.highLim < ptr.highLim) {
                    this.head = interval;
                    this.head.next = ptr;
                    ptr.prev = this.head;
                }
                if (interval.lowLim == ptr.lowLim && interval.highLim > ptr.highLim) {
                    interval.prev = ptr;
                    interval.next = ptr.next;
                    if (ptr.next == null) {
                        ;
                    } else {
                        ptr.next.prev = interval;
                    }
                }
                return;
            } else {
                if (interval.lowLim <= ptr.lowLim) {
                    if (interval.highLim <= ptr.highLim) {
                        interval.prev = ptr.prev;
                        interval.next = ptr;
                        ptr.prev.next = interval;
                        ptr.prev = interval;
                    } else {
                        interval.prev = ptr;
                        interval.next = ptr.next;
                        ptr.next.prev = interval;
                        ptr.next = interval;
                    }
                    return;
                }

            }
            ptr = ptr.next;

        }

    }

    public Set findSmallestCover(List intervals) {

        Set smallest = new Set();

        return smallest;
    }
}// end class List

class TestApp {
    public static void main(String[] args) {
        Node one = new Node(2, 2);
        Node two = new Node(1, 2);
        Node three = new Node(2, 1);
        Node four = new Node(1, 3);

        List list = new List(one);
        list.addInterval(two);
        list.addInterval(three);
        list.addInterval(four);

        Node curr = list.head;
        while (curr != null) {
            System.out.println(curr.toString());
            curr = curr.next;
        }

        System.out.println("LowExtreme : " + list.lowExtreme);
        System.out.println("HighExtreme : " + list.highExtreme);

        Set s = new Set();
        s.addElement(1);
        s.addElement(2);
        System.out.println(s.toString());
    }

}// end TestApp
