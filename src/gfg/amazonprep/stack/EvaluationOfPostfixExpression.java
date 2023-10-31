package gfg.amazonprep.stack;

import java.util.Stack;

public class EvaluationOfPostfixExpression {
    public static void main(String[] args) {

    }

    public static int evaluatePostFix(String exp){
        String input[] = exp.split("");
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < input.length; ++index) {
            if (input[index].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (input[index].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else if (input[index].equals("-")) {
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
        return stack.pop();
    }
}
