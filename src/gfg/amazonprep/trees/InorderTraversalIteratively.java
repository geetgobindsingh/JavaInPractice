package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalIteratively extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(50);

        root.left = a;
        root.right = b;
        a.left = c;
        c.right = d;

        for (Integer i : inOrder(root)) {
            System.out.print(i);
        }
        System.out.println();
        inOrderTraversal(root);

    }

    public static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root;
        while (!done) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    current = stack.pop();
                    result.add(current.data);
                    current = current.right;
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> inOrder1(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null && !stack.peek().left.visited) {
                stack.push(stack.peek().left);
            }
            Node cur = stack.pop();
            cur.visited = true;
            result.add(cur.data);
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return result;
    }
}
