package gfg.amazonprep.linkedlist;

public class ReverseALinkedList extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printList(reverseList(node));
    }

    public static Node reverseList(Node head) { // my original
        Node cur = head;
        Node prev = head;
        Node next = null;
        while (cur.next != null) {
           next = cur.next;
           cur.next = next.next;
           next.next = prev;
           prev = next;
        }
        return prev;
    }

    public static Node reverseList1(Node head) { //copied from net
        Node prev = null;
        Node temp = null;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
}
