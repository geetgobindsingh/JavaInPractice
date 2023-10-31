package gfg.amazonprep.linkedlist;

public class NthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(getNthFromLast(head, 1));
    }

    public static int getNthFromLast(Node head, int n) {
        Node fastP = head;
        while (n > 0) {
            if (fastP == null) {
                return -1;
            }
            fastP = fastP.next;
            n--;
        }
        Node slowP = head;
        while (fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next;
        }
        return slowP.data;
    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
