package gfg.amazonprep.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
//TODO: @Easy
public class SpecialStack {
    public static void main(String[] args) {

    }

    static class SStack {
        Stack<Integer> minStack = new Stack<>();

        public void push(int a, Stack<Integer> s) {
            s.add(a);
            if (!minStack.isEmpty()) {
                int min = minStack.peek();
                if (min >= a) {
                    minStack.add(a);
                }
            } else {
                minStack.add(a);
            }
        }

        public int pop(Stack<Integer> s) {
            int a = s.peek();
            if (!minStack.isEmpty()) {
                int min = minStack.peek();
                if (min == a) {
                    minStack.pop();
                }
            }
            return s.pop();
        }

        public int min(Stack<Integer> s) {
            return minStack.peek();
        }

        public boolean isFull(Stack<Integer> s, int n) {
            return s.size() == n;
        }

        public boolean isEmpty(Stack<Integer> s) {
            return s.size() == 0;
        }
    }
}
