package gfg.amazonprep.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    public static void main(String[] args) {
        QueueStack queueStack = new QueueStack();
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        int i = 0;
        while (i < 3) {
            i++;
            System.out.println(queueStack.pop());
        }
    }

    static class QueueStack {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        /*The method pop which return the element poped out of the stack*/
        int pop() {
            int out = -1;
            if (q1.isEmpty()) {
                while (!q2.isEmpty()) {
                    if (q2.size() == 1) {
                        out = q2.remove();
                    } else {
                        q1.add(q2.remove());
                    }
                }
                return out;
            } else {
                while (!q1.isEmpty()) {
                    if (q1.size() == 1) {
                        out = q1.remove();
                    } else {
                        q2.add(q1.remove());
                    }
                }
                return out;
            }
        }

        /* The method push to push element into the stack */
        void push(int a) {
            // Your code here
            if (q1.isEmpty()) {
                q2.add(a);
            } else {
                q1.add(a);
            }
        }
    }
}
