package leetcode.medium;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        head.next.next = new ReverseLinkedList.ListNode(3);
        head.next.next.next = new ReverseLinkedList.ListNode(4);
        head.next.next.next.next = new ReverseLinkedList.ListNode(5);
        head.next.next.next.next.next = new ReverseLinkedList.ListNode(6);
        displayList(head);
        System.out.println(obj.pairSum(head));
        displayList(obj.reverseList(head));
    }

    public int pairSum(ListNode head) {
        int n = 0;
        ListNode iter = head;
        while (iter != null) {
            n++;
            iter = iter.next;
        }
        iter = head;
        ListNode prev = null;
        int i = 0;
        while (iter != null && i < (n/2)) {
            i++;
            prev = iter;
            iter = iter.next;
        }
        prev.next = reverseList(prev.next);
        iter = prev.next;
        int sum = 0;
        while (iter != null) {
            sum = Math.max(sum, head.val + iter.val);
            head = head.next;
            iter = iter.next;
        }
        return sum;
    }

    private static void displayList(ReverseLinkedList.ListNode head) {
        ReverseLinkedList.ListNode first = head;
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
        System.out.print("\n");
    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null) return head;
//        ListNode prev = head;
//        ListNode cur = head;
//        ListNode next = null;
//        while (cur.next != null) {
//            next = cur.next;
//            cur.next = next.next;
//            next.next = prev;
//            prev = next;
//        }
//        return prev;
//    }

    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode front = head;
        while (front != null) {
            ListNode temp = front.next;
            if (newList == null) {
                front.next = null;
            } else {
                front.next = newList;
            }
            newList = front;
            front = temp;
        }
        return newList;
    }

    public static class ListNode {
        int val;
        ReverseLinkedList.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ReverseLinkedList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
