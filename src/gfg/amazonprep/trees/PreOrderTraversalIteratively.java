package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversalIteratively extends BaseTree {
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

        for (Integer i : preOrder(root)) {
            System.out.print(i);
        }
        System.out.println();
        preOrderTraversal(root);

    }

    public static ArrayList<Integer> preOrder(Node root) {
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
                result.add(current.data);
                if (current.right != null) {
                    stack.add(current.right);
                }
                if (current.left != null) {
                    stack.add(current.left);
                }
            }
        }
        return result;
    }

}
