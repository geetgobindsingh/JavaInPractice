package gfg.amazonprep.stack;

import java.util.Stack;

//TODO: @Easy
public class ParenthesisChecker {
    public static void main(String[] args) {
        System.out.println(ispar("({([])}{([])})"));
    }

    public static boolean ispar(String x) {
        boolean balanced = true;
        if (x.isEmpty()) {
            return true;
        }
        if (x.length() % 2 == 1) {
            return false;
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
            } else {
                balanced = false;
                break;
            }
        }

        return balanced;
    }
}
