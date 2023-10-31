package gfg.amazonprep.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    public static void main(String[] args) {

    }

    public Queue<Integer> rev(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        return q;
    }
}
