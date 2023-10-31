package gfg.amazonprep.linkedlist;

public class RearrangeALinkedList extends BaseLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(2);
        Node node5 = new Node(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printList(rearrangeEvenOdd(node1));
    }

    public static Node rearrangeEvenOdd(Node head) {
        int index = 1;
        Node current = head;
        Node lastZero = head;
        while (current != null) {
            if (index % 2 != 0 ) {
                int temp = current.data;
                current.data = lastZero.data;
                lastZero.data = temp;
                lastZero = lastZero.next;
            }
            current = current.next;
            index++;
        }
        return head;
    }
}
