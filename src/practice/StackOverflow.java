package practice;

import java.util.Stack;

public class StackOverflow {

    public int i = 0;

    public static void main(String[] args) {
        StackOverflow obj = new StackOverflow();
        try {
            obj.getInt();
        } catch (Error e) {
            System.out.println(obj.i); // ~64K
        }
        try {
            obj.stack();
        } catch (Error e) {
            System.out.println(obj.i); // 1/0 infinity
        }


    }

    public int getInt() {
        i = i + 1;
        return getInt();
    }

    public void stack() {
        i = 0;
        Stack<Integer> stack = new Stack<>();
        while (true) {
            try {
                stack.push(i++);
            } catch (Error r) {
                break;
            }
        }
    }
}
