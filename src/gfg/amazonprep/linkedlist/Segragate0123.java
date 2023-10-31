package gfg.amazonprep.linkedlist;

public class Segragate0123 {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(0);
        Node node3 = new Node(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        printList(segregate(node));
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

    public static Node segregate(Node head) {
        Node current = head;
        Node lastZero = head;
        while (current != null) {
            if (current.data == 0) {
                int temp = current.data;
                current.data = lastZero.data;
                lastZero.data = temp;
                lastZero = lastZero.next;
            }
            current = current.next;
        }

        current = lastZero;
        Node lastOne = lastZero;
        while (current != null) {
            if (current.data == 1) {
                int temp = current.data;
                current.data = lastOne.data;
                lastOne.data = temp;
                lastOne = lastOne.next;
            }
            current = current.next;
        }
        return head;
    }


}
