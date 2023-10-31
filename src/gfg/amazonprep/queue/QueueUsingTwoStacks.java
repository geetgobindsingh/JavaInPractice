package gfg.amazonprep.queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.Push(1);
        stackQueue.Push(2);
        stackQueue.Push(3);
        System.out.println(stackQueue.Pop());
        System.out.println(stackQueue.Pop());
        System.out.println(stackQueue.Pop());
    }

    static class StackQueue {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        /* The method insert to push element
           into the queue */
        void Push(int x) {
            s1.push(x);
        }


        int Pop() {
            int result = -1;
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                result = s2.isEmpty() ? -1 : s2.pop();
            } else {
                result = s2.pop();
            }
            return result;
        }

        /* The method remove which return the
          element popped out of the queue*/
        int Pop1() {
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int result = s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return result;
        }
    }
}
