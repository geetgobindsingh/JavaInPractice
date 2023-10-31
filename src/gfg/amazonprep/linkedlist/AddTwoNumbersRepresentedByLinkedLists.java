package gfg.amazonprep.linkedlist;


import java.util.Stack;

public class AddTwoNumbersRepresentedByLinkedLists extends BaseLinkedList {
    public static void main(String[] args) {
        Node first = new Node(9);
        first.next = new Node(9);

        Node second = new Node(9);
        Node b = new Node(9);
        Node c = new Node(9);
        second.next = b;
        b.next = c;

        printList(addLists(first, second));
    }

    public static Node addLists(Node first, Node second) {

        Node newListHead = null;
        Node current = first;
        java.math.BigInteger one = new java.math.BigInteger("0"), two = new java.math.BigInteger("0"), ten = new java.math.BigInteger("10");
        while (current != null) {
            one = one.multiply(ten).add(new java.math.BigInteger(String.valueOf(current.data)));
            current = current.next;
        }
        current = second;
        while (current != null) {
            two = two.multiply(ten).add(new java.math.BigInteger(String.valueOf(current.data)));
            current = current.next;
        }
        java.math.BigInteger sum = one.add(two);
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
