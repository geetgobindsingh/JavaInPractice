package gfg.amazonprep.linkedlist;

public class DeleteKeysInALinkedList extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(1);

        node.next = node1;
        node1.next = node3;
        node3.next = node4;

        printList(deleteAllOccurances(node, 2));
    }

    public static Node deleteAllOccurances(Node head, int x) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            if (cur.data == x) {
                if (prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
