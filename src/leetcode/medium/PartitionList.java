package leetcode.medium;

public class PartitionList {

    /*
    Input: head = [1,4,3,2,5,2], x = 3
    Output: [1,2,2,4,3,5]

    Input: head = [2,1], x = 2
    Output: [1,2]
     */
    public static void main(String[] args) {
        displayNode(partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
        displayNode(partition(new ListNode(2, new ListNode(1)), 2));
    }

    public static void displayNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("\n");
    }

    public static ListNode partition(ListNode head, int x) {
        displayNode(head);
        ListNode d1 = new ListNode();
        ListNode d2 = new ListNode();
        ListNode t1 = d1, t2 = d2;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                t1.next = current;
                t1 = t1.next;
            } else {
                t2.next = current;
                t2 = t2.next;
            }
            current = current.next;
        }
        t1.next = d2.next;
        t2.next = null;
        return d1.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
