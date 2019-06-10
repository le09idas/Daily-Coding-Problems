import java.util.ArrayList;

//intervalCoverTest
class Set {
    ArrayList<String> set;

    public Set() {
        this.set = new ArrayList<String>();
    }

    public void addElement(int e) {

        for (int i = 0; i < this.set.size(); i++) {
            if (this.set.get(i).compareTo(Integer.toString(e)) == 0) {
                return;
            }

        }
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

    public boolean isSubset(Node target) {
        if (this.lowLim <= target.lowLim && this.highLim >= target.highLim) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lowIntersect(Node target) {
        if (this.lowLim <= target.lowLim && this.highLim >= target.lowLim && this.lowLim < target.highLim
                && this.highLim < target.highLim) {
            return true;
        }
        return false;
    }

    public boolean highIntersect(Node target) {
        if (this.lowLim < target.lowLim && this.highLim < target.lowLim && this.lowLim >= target.highLim
                && this.highLim <= target.highLim) {
            return true;
        }
        return false;
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
            if (interval.lowLim <= ptr.lowLim && interval.highLim <= ptr.highLim) {
                if (ptr.prev == null) {
                    this.head = interval;
                    interval.next = ptr;
                    ptr.prev = interval;
                } else {
                    interval.prev = ptr.prev;
                    interval.next = ptr;
                    ptr.prev.next = interval;
                    ptr.prev = interval;
                }
                return;
            }
            if (ptr.next == null) {
                ptr.next = interval;
                interval.prev = ptr;
                return;
            }
            ptr = ptr.next;
        }

    }

    public static Set findSmallestCover(List intervals) {

        Set smallest = new Set();

        Node ptr = intervals.head;

        while (ptr != null) {
            if (ptr.prev == null) {
                ptr = ptr.next;
            }
            for (int i = ptr.lowLim; i <= ptr.highLim; i++) {
                if (i > ptr.prev.lowLim && i < ptr.prev.highLim) {
                    smallest.addElement(i);
                } else {
                    smallest.addElement(ptr.prev.highLim);
                }
            }
            ptr = ptr.next;
        }

        return smallest;
    }
}// end class List

class TestApp {
    public static void main(String[] args) {
        Node one = new Node(0, 3);
        Node two = new Node(3, 4);
        Node three = new Node(2, 4);
        Node four = new Node(6, 9);

        System.out.println(three.highIntersect(two));

        List list = new List(one);
        list.addInterval(two);
        list.addInterval(three);
        list.addInterval(four);

        Node curr = list.head;
        while (curr != null) {
            System.out.println(curr.toString());
            curr = curr.next;
        }

        Set smallest = List.findSmallestCover(list);
        System.out.println(smallest.toString());

    }

}// end TestApp
