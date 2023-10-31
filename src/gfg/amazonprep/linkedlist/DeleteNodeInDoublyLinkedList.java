package gfg.amazonprep.linkedlist;

public class DeleteNodeInDoublyLinkedList extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        printList(deleteNode(node, 4));
    }

    public static Node deleteNode(Node head, int x) {
        int i = 1;
        if (x == 1) {
            return head.next;
        }
        Node prev = null;
        Node cur = head;
        while (i < x && cur != null) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        if (i < x) {
            return head;
        }
        prev.next = cur.next;
        return head;
    }
}
