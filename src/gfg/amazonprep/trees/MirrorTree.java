package gfg.amazonprep.trees;

import java.util.Stack;

public class MirrorTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
//        Node c = new Node(40);
//        Node d = new Node(50);

        root.left = a;
        root.right = b;
//        a.left = c;
//        a.right = d;
        preOrderTraversal(root);
        mirror(root);
        System.out.println("\n");
        preOrderTraversal(root);
    }

    public static void mirror(Node root) {
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = null;
        stack.add(root);
        while (!done) {
            if (stack.isEmpty()) {
                done = true;
            } else {
                current = stack.pop();
                if (current.left != null && current.right != null) {
                    Node temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                    stack.add(current.right);
                    stack.add(current.left);
                } else if (current.left == null && current.right != null) {
                    current.left = current.right;
                    current.right = null;
                    stack.add(current.left);
                } else if (current.left != null && current.right == null) {
                    current.right = current.left;
                    current.left = null;
                    stack.add(current.right);
                }
            }
        }
    }
}
