package gfg.amazonprep.linkedlist;

public class InsertInASortedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
//        Node node4 = new Node(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
        displayList(sortedInsert(node, 6));
    }

    private static void displayList(Node head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.data + " -> ");
            } else {
                System.out.print(head.data);
            }
            head = head.next;
        }
        System.out.print("\n");
    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node sortedInsert(Node head1, int key) {
        if (head1 == null) return null;
        Node node = new Node(key);
        Node current = head1;

        Node prev = null;
        while (current != null && current.data < key) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            node.next = current;
            head1 = node;
        } else {
            node.next = current;
            prev.next = node;
        }

        return head1;
    }
}
