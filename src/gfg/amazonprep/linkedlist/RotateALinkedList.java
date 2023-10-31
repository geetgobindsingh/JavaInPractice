package gfg.amazonprep.linkedlist;

public class RotateALinkedList {
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
        printList(rotate(node, 2));
    }

    private static void printList(Node reverseList) {
        while (reverseList != null) {
            System.out.print(reverseList.data + " ");
            reverseList = reverseList.next;
        }
    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node rotate(Node head, int k) {
        if (k == 0) return head;
        Node current = head;

        while (current != null && current.next != null) {
            current = current.next;
        }
        current.next = head;

        Node currentNew = head;
        while (k-- > 1 && currentNew != null) {
            currentNew = currentNew.next;
        }

        Node newHead = currentNew.next;
        currentNew.next = null;

        return newHead;
    }
}
