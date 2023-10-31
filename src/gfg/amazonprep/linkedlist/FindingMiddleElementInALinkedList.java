package gfg.amazonprep.linkedlist;

public class FindingMiddleElementInALinkedList {
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
        System.out.println(getMiddle(node));
    }

    public static int getMiddle(Node head) {
        Node slowP = head;
        Node fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
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
