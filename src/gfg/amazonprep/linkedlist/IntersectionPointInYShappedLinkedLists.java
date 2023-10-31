package gfg.amazonprep.linkedlist;

public class IntersectionPointInYShappedLinkedLists {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        head.next = node1;
        node1.next = node4;

//        node2.next = node3;
        node3.next = node4;

        node4.next = node5;

        System.out.println(intersectPoint(head, node3));
    }

    public static int intersectPoint(Node headA, Node headB) {
        int result = -1;
        int lengthA = 0;
        int lengthB = 0;
        Node current = headA;
        while (current != null) {
            current = current.next;
            lengthA++;
        }
        current = headB;
        while (current != null) {
            current = current.next;
            lengthB++;
        }
        if (lengthA > lengthB) {
            int dif = lengthA - lengthB;
            while (dif > 0) {
                headA = headA.next;
                dif--;
            }
            while (headA != null) {
                if (headA == headB) {
                    return headA.data;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        } else {
            int dif = lengthB - lengthA;
            while (dif > 0) {
                headB = headB.next;
                dif--;
            }
            while (headB != null) {
                if (headA == headB) {
                    return headA.data;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        }
        return result;
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
