package gfg.amazonprep.stack;

import java.util.Stack;

public class SearchingChallenge {
    public static void main(String[] args) {
        System.out.println(ispar("([])()"));
        System.out.println(ispar("([])()]"));
        System.out.println(ispar(""));
    }

    public static String ispar(String x) {
        int count = 0;
        boolean balanced = true;
        if (x.isEmpty()) {
            return "1 0";
        }
        if (x.length() % 2 == 1 && !(x.charAt(0) == '('
                || x.charAt(0) == '{'
                || x.charAt(0) == '['
                || x.charAt(0) == ')'
                || x.charAt(0) == '}'
                || x.charAt(0) == ']')) {
            return "1 0";
        }

        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < x.length(); ++index) {
            if (x.charAt(index) == '('
                    || x.charAt(index) == '{'
                    || x.charAt(index) == '[') {
                stack.push(x.charAt(index));
            } else if (!stack.isEmpty() && (x.charAt(index) == ')' && stack.peek() == '('
                    || x.charAt(index) == '}' && stack.peek() == '{'
                    || x.charAt(index) == ']' && stack.peek() == '[')) {
                stack.pop();
                count++;
            } else {
                balanced = false;
                break;
            }
        }
        if (balanced) {
            return "1 " + count;
        }
        return "0";
    }
}
