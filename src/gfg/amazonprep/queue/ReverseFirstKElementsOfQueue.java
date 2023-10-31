package gfg.amazonprep.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        for (Integer i : modifyQueue(queue, 3)) {
            System.out.print(i + " ");
        }
    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if (q.isEmpty() == true || k > q.size()) {
            return q;
        }
        if (k <= 0) {
            return q;
        }

        Stack<Integer> stack = new Stack<Integer>();

        // Push the first K elements into a Stack
        for (int i = 0; i < k; i++) {
            stack.push(q.peek());
            q.remove();
        }

        // Enqueue the contents of stack
        // at the back of the queue
        while (!stack.empty()) {
            q.add(stack.peek());
            stack.pop();
        }

        // Remove the remaining elements and enqueue
        // them at the end of the Queue
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.peek());
            q.remove();
        }
        return q;
    }

    public static Queue<Integer> modifyQueue1(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        while (stack.size() != k) {
            stack.add(q.poll());
        }
        while (!q.isEmpty()) {
            queue.add(q.poll());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            q.add(queue.poll());
        }
        return q;
    }
}
