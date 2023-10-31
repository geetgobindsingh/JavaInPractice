package gfg.amazonprep.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        Node nodeA1 = new Node(3);
        Node nodeA2 = new Node(5);
        Node nodeA3 = new Node(4);
        Node nodeA4 = new Node(1);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;

        printList(findIntersection(node, nodeA1));
    }

    private static void printList(Node reverseList) {
        while (reverseList != null) {
            System.out.print(reverseList.data + " ");
            reverseList = reverseList.next;
        }
    }

    public static Node findIntersection(Node head1, Node head2) {
        Node head = null, result = null;
        Set<Integer> set = new HashSet<>();
        Node current = head2;
        while (current != null) {
            set.add(current.data);
            current = current.next;
        }
        current = head1;
        while (current != null) {
            if (set.contains(current.data)) {
                if (result == null) {
                    result = new Node(current.data);
                    head = result;
                    result.next = null;
                } else {
                    result.next = new Node(current.data);
                    result = result.next;
                    result.next = null;
                }
            }
            current = current.next;
        }
        return head;
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
