package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveHalfNodes extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(7);
        Node a = new Node(7);
        Node b = new Node(8);
        Node c = new Node(2);

        root.left = a;
        root.right = b;
        a.left = c;


        inOrderTraversal(RemoveHalfNodes(root));
    }

    public static Node RemoveHalfNodes(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        if (root.left != null && root.right == null) {
            return RemoveHalfNodes(root.left);
        }
        if (root.right != null && root.left == null) {
            return RemoveHalfNodes(root.right);
        }
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        return root;
    }

    public static Node RemoveHalfNodes1(Node root) {

        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node current = null;

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.left != null
                    && ((current.left.left != null && current.left.right != null)
                    || (current.left.left == null && current.left.right == null))) {
                temp.add(current.left);
            } else {
                if (current.left != null) {
                    if (current.left.left != null) {
                        current.left = current.left.left;
                    } else {
                        current.left = current.left.right;
                    }
                }
            }
            if (current.right != null
                    && ((current.right.left != null && current.right.right != null)
                    || (current.right.left == null && current.right.right == null))) {
                temp.add(current.right);
            } else {
                if (current.right != null) {
                    if (current.right.left != null) {
                        current.right = current.right.left;
                    } else {
                        current.right = current.right.right;
                    }
                }
            }

            if (queue.isEmpty()) {
                while (!temp.isEmpty()) {
                    Node out = temp.poll();
                    queue.offer(out);
                }
            }
        }
        return root;
    }
}
