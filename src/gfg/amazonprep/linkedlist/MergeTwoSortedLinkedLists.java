package gfg.amazonprep.linkedlist;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        Node nodeA1 = new Node(3);
        Node nodeA2 = new Node(5);
        Node nodeA3 = new Node(8);
        Node nodeA4 = new Node(9);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        printList(sortedMerge(node, nodeA1));
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

    public static Node sortedMerge(Node headA, Node headB) {
        Node head = new Node(0);
        Node current = head;
        while (headA != null && headB != null) {
            Node temp = null;
            if (headA.data < headB.data) {
                temp = headA;
                headA = headA.next;
            } else {
                temp = headB;
                headB = headB.next;
            }
            current.next = temp;
            current = temp;
        }
        while (headA != null) {
            Node temp = null;
            temp = headA;
            headA = headA.next;
            current.next = temp;
            current = temp;
        }
        while (headB != null) {
            Node temp = null;
            temp = headB;
            headB = headB.next;
            current.next = temp;
            current = temp;
        }
        return head.next;
    }
}
