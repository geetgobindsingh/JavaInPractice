package gfg.amazonprep.contests;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    //^ greater than * equals to / greater than + equals to -
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            System.out.println(infixToPostfix(sc.nextLine()));
        }
    }

    /*
    A+B
    AB+

    A*(B+C)/D
    A - |* (
    AB - | * ( +
    ABC+ | *
    ABC+* | \
    ABC+*D/
     */

    public static String infixToPostfix(String exp) {
        if (exp.length() > 1) {
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(') {
                    stack.push(exp.charAt(i));
                } else if (exp.charAt(i) == ')') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        } else {
                            result.append(stack.pop());
                        }
                    }
                } else if (exp.charAt(i) == '-' || exp.charAt(i) == '+') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(' || stack.peek() == ')') {
                            break;
                        } else {
                            result.append(stack.pop());
                        }
                    }
                    stack.push(exp.charAt(i));
                } else if (exp.charAt(i) == '*' || exp.charAt(i) == '/') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '-' || stack.peek() == '+' || stack.peek() == '(' || stack.peek() == ')') {
                            break;
                        } else {
                            result.append(stack.pop());
                        }
                    }
                    stack.push(exp.charAt(i));
                } else if (exp.charAt(i) == '^') {
                    stack.push(exp.charAt(i));
                } else {
                    result.append(exp.charAt(i));
                }
            }

            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            return result.toString();
        }
        return exp;
    }
}
