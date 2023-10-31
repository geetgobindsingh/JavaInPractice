package gfg.amazonprep.trees;

import java.util.Stack;

public class LeavesToDLL extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        root.left = a;
        root.right = b;
        a.left = c;
        Node head = convertToDLL(root);
        head = head;
        inOrderTraversal(root);
    }

    public static Node convertToDLL(Node root) {
        Stack<Node> stack = new Stack<>();
        Node head = null;
        Node pointer = null;
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
                    if (current.left == null && current.right == null) {
                        if (head == null) {
                            pointer = new Node(current.data);
                            head = pointer;
                        } else {
                            pointer.right = new Node(current.data);
                            Node prev = pointer;
                            pointer = pointer.right;
                            pointer.left = prev;
                        }
                    }
                    Node temp = current;
                    current = temp.right;
                }
            }
        }
        root = leafDelete(root);
        return head;
    }

    static Node leafDelete(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }

        // Else recursively delete in left and right
        // subtrees.
        root.left = leafDelete(root.left);
        root.right = leafDelete(root.right);

        return root;
    }
}
