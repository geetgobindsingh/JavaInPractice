package gfg.amazonprep.linkedlist;

public class ReverseALinkedListInGroupsOfGivenSize extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        Node node9 = new Node(10);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        printList(reverse(node, 3));
    }

    public static Node reverse(Node head, int k) {
        Node result = null;
        Node temper = null;
        Node cur = head;
        while (cur != null) {
            Node header = cur;
            Node temp = cur;
            for (int i = 0; i < (k-1); i++) {
                if (temp != null) {
                    temp = temp.next;
                }
            }
            if (temp == null) {
                cur = null;
            } else {
                cur = temp.next;
                temp.next = null;
            }
            Node reverse = reverse(header);
            if (result == null) {
                result = reverse;
            } else {
                temper = result;
                while (temper.next != null) {
                    temper = temper.next;
                }
                temper.next = reverse;
            }
        }
        return result;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node temp = null;
        Node cur = head;
        while (cur != null) {
            temp = cur;
            cur = cur.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    public static Node reverse1(Node head, int k) {
        Node header = null, lastPrev = null, prev = null, next = head;
        int count = 0;
        while (head != null) {
            while (head != null && count != k) {
                Node temp = head;
                head = head.next;
                temp.next = prev;
                prev = temp;
                count++;
            }
            if (count == k) {
                header = prev;
                count = 0;
            }
            if (lastPrev == null) {
                lastPrev = prev;
            } else {
                lastPrev.next = prev;
            }
            next.next = head;
            prev = null;
            next = head;
        }
        return header;
    }
}
