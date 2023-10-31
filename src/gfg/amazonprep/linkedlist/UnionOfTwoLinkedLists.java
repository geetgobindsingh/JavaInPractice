package gfg.amazonprep.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoLinkedLists extends BaseLinkedList {
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

        printList(findUnion(node, nodeA1));
    }

    public static Node findUnion(Node head1, Node head2) {
        Set<Integer> set = new HashSet<>();

        Node current = head1;
        while (current != null) {
            set.add(current.data);
            current = current.next;
        }

        current = head2;
        while (current != null) {
            set.add(current.data);
            current = current.next;
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Node head = null;
        current = null;
        for (Integer data : list) {
            if (head == null) {
                head = new Node(data);
                current = head;
            } else {
                current.next = new Node(data);
                current = current.next;
            }
        }
        return head;
    }
}
