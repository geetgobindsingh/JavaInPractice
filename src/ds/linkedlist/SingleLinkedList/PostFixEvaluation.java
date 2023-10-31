package ds.linkedlist.SingleLinkedList;

import ds.stack.Stack;

public class PostFixEvaluation {
    public static void main(String[] args) {
        String input[] = "23+52-+".split(""); //8
        Stack stack = new Stack();
        for (int index = 0; index < input.length; ++index) {
            if (input[index].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (input[index].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else {
                stack.push(Integer.parseInt(input[index]));
            }
        }

        System.out.println(stack.pop());
    }
}
