package gfg.amazonprep.trees;

import java.util.Stack;

public class BinaryTreeToCDLL extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(60);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        Node head = bTreeToClist(root);
        head = head;
    }


    static Node bTreeToClist(Node root) {
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
                    if (head == null) {
                        pointer = new Node(current.data);
                        head = pointer;
                    } else {
                        pointer.right = new Node(current.data);
                        Node prev = pointer;
                        pointer = pointer.right;
                        pointer.left = prev;
                    }
                    Node temp = current;
                    current = temp.right;
                }
            }
        }
        pointer.right = head;
        head.left = pointer;
        return head;
    }
}

