package dailyproblems;

import sun.misc.Queue;

public class DayOne {

    /*
    Problem Statement:
    Given a stack of N elements,
    - Interleave the first half of the stack with the second half reversed using only one other queue.
    This should be done in-place.
    Recall that you can only push or pop from a stack, and enqueue or dequeue from a queue.
    For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3].
    If the stack is [1, 2, 3, 4], it should become [1, 4, 2, 3].

    Hint: Try working backwords from the end state.
    */

    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        transform(stack);
        System.out.print(stack);
    }

    private static void transform(java.util.Stack<Integer> stack) {
        Queue<Integer> queue = new sun.misc.Queue<>();
        int cycle = stack.size() - 1;
        while (cycle > 0) {
            for (int i = cycle; i > 0; --i) {
                queue.enqueue(stack.pop());
            }
            while (!queue.isEmpty()) {
                try {
                    stack.push(queue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cycle--;
        }
    }
}
