package gfg.amazonprep.linkedlist;

public class MergeSortForLinkedList extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(3);
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        printList(mergeSort(node));
    }

    public static Node mergeSort(Node head) {
        Node mid = getMiddle(head);
        Node temp = mid.next;
        mid.next = null;
        if (mid != head) {
            mergeSort(head);
            mergeSort(temp);
            sortedMerge(head, temp);
        }
        return head;
    }


    public static Node mergeSort1(Node head) {
        Node lastNode = head;
        while (lastNode != null && lastNode.next != null) {
            lastNode = lastNode.next;
        }
        applyMergeSorting(head, lastNode);
        return head;
    }

    public static void applyMergeSorting(Node headA, Node headB) {
        if (headA != headB) {
            Node mid = getMiddle(headA);
            applyMergeSorting(headA, mid);
            applyMergeSorting(mid, headB);
            sortedMerge(headA, mid);
        }
    }

    public static Node getMiddle(Node head) {
        Node slowP = head;
        Node fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        return slowP;
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
