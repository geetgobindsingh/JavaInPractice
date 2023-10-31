package gfg.amazonprep.bst;

import java.util.Stack;

public class InorderSuccessorInBST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(20);
        Node a = new Node(8);
        Node b = new Node(22);
        Node c = new Node(4);
        Node d = new Node(12);
        Node e = new Node(10);
        Node f = new Node(14);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = e;
        d.right = f;
        System.out.print(inorderSuccessor(root, a).data);
    }

    public static Node inorderSuccessor(Node root, Node x) { // O(h)
        if (x.right != null) {
            return minValue(x.right);
        }
        if (root == x) {
            return null;
        }
        Node current = root;
        Node result = root;
        while (current != null) {
            if (current.left != null && current.left == x) {
                result = current;
                break;
            } else if (current.right != null && current.right == x) {
                break;
            }
            if(current.data < x.data) {
                current = current.right;
            } else if(current.data > x.data) {
                result = current;
                current = current.left;
            }
        }
        if (result.data > x.data) {
            return result;
        }
        return new Node(-1);
    }

    public static Node minValue(Node root) {
        if (root != null && (root.left == null && root.right == null)) {
            return root;
        }
        if (root.left == null) {
            return root;
        }
        return minValue(root.left);
    }

    public static Node inorderSuccessor1(Node root, Node x) { // O(n)
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root;
        boolean found = false;
        Node inorderSuccessor = null;
        while (!done) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    current = stack.pop();
                    if (found) {
                        inorderSuccessor = current;
                        break;
                    }
                    found = current == x;
                    current = current.right;
                }
            }
        }
        return inorderSuccessor;

    }


}
