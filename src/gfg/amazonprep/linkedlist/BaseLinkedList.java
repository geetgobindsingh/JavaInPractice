package gfg.amazonprep.linkedlist;

public class BaseLinkedList {

    public static void printList(Node reverseList) {
        while (reverseList != null) {
            System.out.print(reverseList.data + " ");
            reverseList = reverseList.next;
        }
    }

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
