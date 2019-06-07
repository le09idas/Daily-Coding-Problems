//intervalCoverTest
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
        while (true) {
            if (interval.lowLim < ptr.lowLim && interval.highLim <= ptr.lowLim) {
                if (ptr.prev == null) {
                    this.head = interval;
                    this.head.next = ptr;
                    this.lowExtreme = this.head.lowLim;
                } else {
                    interval.prev = ptr;
                    interval.next = ptr.next;
                    ptr.next = interval;
                }
                return;
            }
            if (interval.lowLim == ptr.lowLim && interval.highLim <= ptr.highLim) {
                interval.prev = ptr.prev;
                interval.prev.next = interval;
                interval.next = ptr;
                ptr.prev = interval;
                return;
            }
            if (interval.lowLim == ptr.lowLim && interval.highLim >= ptr.highLim) {
                interval.next = ptr.next;
                ptr.next = interval;
                interval.prev = ptr;
                return;
            }
            if (ptr.next == null) {
                ptr.next = interval;
                interval.prev = ptr;
                if (interval.highLim >= ptr.highLim)
                    this.highExtreme = interval.highLim;
                return;
            }
            ptr = ptr.next;
        }

    }
}

class TestApp {
    public static void main(String[] args) {
        Node one = new Node(1, 2);
        Node two = new Node(2, 2);
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
    }

}// end TestApp