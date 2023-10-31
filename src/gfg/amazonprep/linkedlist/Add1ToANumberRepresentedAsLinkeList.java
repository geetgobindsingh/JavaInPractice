package gfg.amazonprep.linkedlist;

public class Add1ToANumberRepresentedAsLinkeList extends BaseLinkedList {
    public static void main(String[] args) {

        Node node = new Node(9);
        Node node1 = new Node(9);
        Node node2 = new Node(9);
        node.next = node1;
        node1.next = node2;
        printList(addOne(node));

    }

    public static Node addOne(Node head) {

        if (head == null) return null;

        Node prev = null;
        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }

        int inc = 1;

        head = prev;

        while (inc > 0) {
            int data = prev.data;
            if ((data + inc) >= 10) {
                prev.data = (data + inc) % 10;
                if (prev.next == null) {
                    prev.next = new Node(0);
                }
                prev = prev.next;
            } else {
                prev.data = (data + inc);
                inc--;
            }
        }


        prev = null;
        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
}
