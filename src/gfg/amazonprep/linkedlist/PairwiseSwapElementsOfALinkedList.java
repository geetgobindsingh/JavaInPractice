package gfg.amazonprep.linkedlist;

public class PairwiseSwapElementsOfALinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        printList(pairwiseSwap(node1));
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

    public static Node pairwiseSwap(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node cur = head;
        while (cur != null && cur.next != null) {
           int data = cur.data;
           cur.data = cur.next.data;
           cur.next.data = data;
           cur = cur.next.next;
        }

        return head;
    }

    public static Node pairwiseSwap1(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node temp = head.next;

        Node current = head;
        Node next = null;
        Node prev = null;
        while (current != null && current.next != null) {
            next = current.next;
            if (next.next == null) {
                current.next = null;
                next.next = current;
                break;
            } else {
                current.next = next.next;
                next.next = current;
                current = current.next;
            }
        }

        return temp;
    }


}
