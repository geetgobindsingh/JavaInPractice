package leetcode.hard;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class MergeKSortedLists {


    // Definition for singly-linked list.
    public static class ListNode {
        Integer val;
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

    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode item1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode item2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode item3 = new ListNode(2, new ListNode(6));
        display(obj.mergeKLists(new ListNode[]{item1, item2, item3}));
        display(obj.mergeKLists(new ListNode[]{}));
        display(obj.mergeKLists(new ListNode[]{new ListNode()}));
    }

    private static void display(ListNode listNode) {
        ListNode head = listNode;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print("\n");
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        for (int i = 0; i < n - 1; ++i) {
            lists[i + 1] = mergeLists(lists[i], lists[i + 1]);
        }
        return lists[n - 1];
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    static class Pair implements Comparable<Pair> {

        final Integer val;
        final int listIndex;

        Pair(int val, int listIndex) {
            this.val = val;
            this.listIndex = listIndex;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        ListNode head = new ListNode(0);
        ListNode result = head;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (lists[i].val != null) {
                pq.offer(new Pair(lists[i].val, i));
            }
        }
        while (pq.size() > 0) {
            Pair p = pq.poll();
            ListNode node = lists[p.listIndex];
            lists[p.listIndex] = node.next;
            if (lists[p.listIndex] != null && lists[p.listIndex].val != null) {
                pq.offer(new Pair(lists[p.listIndex].val, p.listIndex));
            }
            result.next = node;
            result = result.next;

        }
        return head.next;
    }
}













