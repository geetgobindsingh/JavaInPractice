package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostOrderTraversalIteratively extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(50);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        for (Integer i : postOrder(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
        postOrderTraversal(root);

    }

    // TODO: @Important
    // Using 1 stack with a Hack
    // https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
    public static ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root;
        while (!done) {
            if (current != null) {
                stack.push(current);
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    current = stack.pop();
                    if (!stack.isEmpty() && stack.peek() == current) {
                        current = current.right;
                    } else {
                        result.add(current.data);
                        current = null;
                    }
                }
            }
        }

        return result;
    }

    // With Single Stack and reverse order list
    public static ArrayList<Integer> postOrder1(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = null;
        stack.add(root);
        while (!done) {
            if (stack.isEmpty()) {
                done = true;
            } else {
                current = stack.pop();
                if (current.left != null) {
                    stack.add(current.left);
                }
                if (current.right != null) {
                    stack.add(current.right);
                }
                result.add(current.data);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
