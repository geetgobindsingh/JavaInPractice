package ds.linkedlist.SingleLinkedList;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String[] input = "2+3+5-2".split("");
        String[] output = getPostFix(input, input.length);
        for(String sr : output) {
            System.out.print(sr + " ");
        }
    }

    private static String[] getPostFix(String[] ar, int length) {
        String[] out = new String[length];
        Stack<Character> stack = new Stack<>();
        int k = 0;
        for (int index = 0; index < length; ++index) {
            if (ar[index].charAt(0) == '+') {
                if (!stack.isEmpty()) {
                    out[k++] = ar[index];
                    out[k++] = stack.pop().toString();
                }
                stack.push('+');
            } else if (ar[index].charAt(0) == '-') {
                if (!stack.isEmpty()) {
                    out[k++] = stack.pop().toString();
                }
                stack.push('-');
            } else {
                out[k++] = ar[index];
            }
        }
        return out;
    }
}
