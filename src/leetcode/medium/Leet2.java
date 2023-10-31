package leetcode.medium;

import java.math.BigInteger;
import java.util.List;

public class Leet2 {

    /*
    You are given two non-empty linked lists representing two non-negative integers.
     The digits are stored in reverse order and each of their nodes contain a single digit.
      Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Input: (5) + (5)
Output: 0 -> 1
Explanation: 5 + 5 = 10.

[9]
[1,9,9,9,9,9,9,9,9,9]

[1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1]

[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
[5,6,4]

[8,9,9]
[2]
     */

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

                ListNode l1 = new ListNode(8);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);

//        ListNode l1 = new ListNode(9);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(1);
//        l1.next.next.next = new ListNode(1);
//        l1.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(1);
//        l2.next.next = new ListNode(1);
//        l2.next.next.next = new ListNode(1);
//        l2.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next.next.next.next = new ListNode(1);

        ListNode result = addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val +"|");
            result = result.next;
        }

    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = null, current = null;
//        BigInteger a = BigInteger.ZERO;
//        BigInteger b = BigInteger.ZERO;
//        current = l1;
//        for (int index = 0; current != null; ++index) {
//            if (index == 0) {
//                a = BigInteger.valueOf(current.val);
//            } else {
//                a = a.add(BigInteger.valueOf(current.val * (long) Math.pow(10, index)));
//            }
//            current = current.next;
//        }
//        current = l2;
//        for (int index = 0; current != null; ++index) {
//            if (index == 0) {
//                b = BigInteger.valueOf(current.val);
//            } else {
//                b = b.add(BigInteger.valueOf(current.val * (long) Math.pow(10, index)));
//            }
//            current = current.next;
//        }
//        BigInteger sum = a.add(b);
//
//        result = new ListNode((sum.mod(BigInteger.valueOf(10))).intValue());
//        sum = sum.divide(BigInteger.valueOf(10));
//
//        current = result;
//        while (sum.signum() == 1) {
//            current.next = new ListNode((sum.mod(BigInteger.valueOf(10))).intValue());
//            sum = sum.divide(BigInteger.valueOf(10));
//            current = current.next;
//        }
//
//        return result;
//    }
//
//
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        if (l1 == null || l2 == null) {
            if (l1 != null) {
                if (l1.val > 9) {
                    l1.val = l1.val % 10;
                    if (l1.next != null) {
                        l1.next.val = l1.next.val + 1;
                        result = l1;
                        result.next = addTwoNumbers(l1.next, null);
                    } else {
                        l1.next = new ListNode(1);
                        result = l1;
                    }
                } else {
                    result = l1;
                }
            } else if (l2 != null) {
                if (l2.val > 9) {
                    l2.val = l2.val % 10;
                    if (l2.next != null) {
                        l2.next.val = l2.next.val + 1;
                        result = l2;
                        result.next = addTwoNumbers(null, l2.next);
                    } else {
                        l2.next = new ListNode(1);
                        result = l2;
                    }
                } else {
                    result = l2;
                }
            }
        } else {
            int newval = l1.val + l2.val;
            int addon = 0;
            if (newval > 9) {
                addon = 1;
                newval = newval % 10;
            }
            result = new ListNode(newval);

            if (l1.next == null || l2.next == null) {
                if (l1.next != null) {
                    l1.next.val = l1.next.val + addon;
                } else if (l2.next != null) {
                    l2.next.val = l2.next.val + addon;
                } else if (addon > 0) {
                    l1.next = new ListNode(addon);
                }
            } else {
                l1.next.val = l1.next.val + addon;
            }
            result.next = addTwoNumbers(l1.next, l2.next);
        }
        return result;
    }


    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
