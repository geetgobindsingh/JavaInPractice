package leetcode.medium;


public class OddEven {
    public static void main(String[] args) {
        OddEven obj = new OddEven();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        displayList(head);
        displayList(obj.oddEvenList(head));
    }

    private static void displayList(ListNode head) {
        ListNode first = head;
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
        System.out.print("\n");
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode first = head;
        ListNode temp = head.next;
        ListNode second = head.next;
        while (second != null && second.next != null) {
            first.next = second.next;
            second.next = first.next.next;

            first = first.next;
            second = second.next;
        }
        first.next = temp;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
