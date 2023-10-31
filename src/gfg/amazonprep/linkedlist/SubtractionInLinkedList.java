package gfg.amazonprep.linkedlist;

import java.util.Stack;

public class SubtractionInLinkedList extends BaseLinkedList {
    public static void main(String[] args) {

        Node first = new Node(5);
        first.next = new Node(9);
        first.next.next = new Node(7);
        first.next.next.next = new Node(2);


        Node second = new Node(0);
        second.next = new Node(0);
        second.next.next = new Node(0);
        second.next.next.next = new Node(3);
        second.next.next.next.next = new Node(4);
        second.next.next.next.next.next = new Node(5);
        second.next.next.next.next.next.next = new Node(1);
        second.next.next.next.next.next.next.next = new Node(6);
        second.next.next.next.next.next.next.next.next = new Node(2);
        printList(subLinkedList(first, second));
    }

    public static Node subLinkedList(Node l1, Node l2) { // fast
        String one = "", two = "";
        Node current = l1;
        boolean skip = true;
        while (current != null) {
            skip = skip && current.data == 0;
            if (skip) {
                current = current.next;
                continue;
            }
            one = one + String.valueOf(current.data);
            current = current.next;
        }
        current = l2;
        while (current != null) {
            skip = skip && current.data == 0;
            if (skip) {
                current = current.next;
                continue;
            }
            two = two + String.valueOf(current.data);
            current = current.next;
        }
        if (one.length() > two.length()) {
            String temp = one;
            one = two;
            two = temp;
        }


        int dif = two.length() - one.length();
        while (dif > 0) {
            dif--;
            one = "0" + one;
        }

        String result = "";
        for (int index = one.length() - 1; index >= 0 && index > dif; index--) {
            int i = index;
            int a = Integer.parseInt(String.valueOf(two.charAt(i)));
            int b = Integer.parseInt(String.valueOf(one.charAt(index)));
            if (a >= b) {
                result = result + (a - b);
            } else {
                i--;
                for (; i >= 0; i--) {
                    int t = Integer.parseInt(String.valueOf(two.charAt(i)));
                    if (t >= 1) {
                        two = two.substring(0, i) + (t - 1) + two.substring(i + 1);
                        break;
                    } else {
                        two = two.substring(0, i) + 9 + two.substring(i + 1);
                    }
                }
                result = result + (10 + a - b);
            }
        }
        if(result.length() < two.length()) {
            int in = 0;
            skip = two.charAt(in) == '0';
            int diff = two.length() - result.length();
            while (diff > 0) {
                diff--;
                if (skip) {
                    skip = two.charAt(in) == '0';
                    continue;
                }
                result = result + two.charAt(in);
            }
        }
        String tt = result;
        result = "";
        skip = true;
        int index = tt.length() - 1;
        for (; index >=0 ; index--) {
            skip = skip  && tt.charAt(index) == '0';
            if (skip) {
                continue;
            }
            result = result + tt.charAt(index);
        }
        Node node = null;
        index = 0;

        for (; index < result.length() ; index++) {
            skip = skip && two.charAt(index) == '0';
            if (skip) {
                continue;
            }
            if (node == null) {
                node = new Node(Integer.parseInt(String.valueOf(result.charAt(index))));
                current = node;
            } else {
                current.next = new Node(Integer.parseInt(String.valueOf(result.charAt(index))));
                current = current.next;
            }
        }
        if (node == null) {
            return new Node(0);
        }
        return node;
    }


    public static Node subLinkedList1(Node l1, Node l2) { // slow
        Node newListHead = null;
        Node current = l1;
        java.math.BigInteger one = new java.math.BigInteger("0"), two = new java.math.BigInteger("0"), ten = new java.math.BigInteger("10");
        while (current != null) {
            one = one.multiply(ten).add(new java.math.BigInteger(String.valueOf(current.data)));
            current = current.next;
        }
        current = l2;
        while (current != null) {
            two = two.multiply(ten).add(new java.math.BigInteger(String.valueOf(current.data)));
            current = current.next;
        }
        java.math.BigInteger sum;
        if (one.compareTo(two) < 0) {
            sum = two.subtract(one);
        } else {
            sum = one.subtract(two);
        }
        if (sum.compareTo(java.math.BigInteger.ZERO) == 0) {
            newListHead = new Node(0);
            return newListHead;
        }
        current = newListHead;
        Stack<Integer> stack = new Stack();
        while (sum.compareTo(java.math.BigInteger.ZERO) > 0) {
            stack.push(sum.mod(ten).intValue());
            sum = sum.divide(ten);
        }

        while (!stack.isEmpty()) {
            if (newListHead == null) {
                newListHead = new Node(stack.pop());
                current = newListHead;
            } else {
                current.next = new Node(stack.pop());
                current = current.next;
            }
        }
        return newListHead;
    }
}
