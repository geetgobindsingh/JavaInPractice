package leetcode.medium;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        displayList(head);
        ReverseLinkedListII obj = new ReverseLinkedListII();
        head = obj.reverseBetween(head, 1, 4);
        displayList(head);
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        displayList(obj.reverseBetween(head, 2, 4));
    }

    private static void displayList(ListNode head) {
        ListNode iter = head;
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
        System.out.print("\n");
    }


    //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

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


    public ListNode reverseBetween(ListNode head, int left, int right) {

        int i = 1;
        ListNode curr = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode prev = null;
        while (curr != null && i < (right + 1)) {
            if (i == left) {
                leftNode = curr;
            }
            if (leftNode == null) {
                prev = curr;
            }
            if (i == right) {
                rightNode = curr;
            }
            i++;
            curr = curr.next;
        }
        ListNode temp = rightNode.next;
        rightNode.next = null;
        leftNode = reverseList(leftNode);
        if (prev == null) {
            head = leftNode;
        } else {
            prev.next = leftNode;
        }
        while (leftNode != null && leftNode.next != null) {
            leftNode = leftNode.next;
        }
        leftNode.next = temp;
        return head;
    }
}
