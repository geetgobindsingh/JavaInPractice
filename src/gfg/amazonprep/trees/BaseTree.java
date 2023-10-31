package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.Queue;

public abstract class BaseTree {
    public static class Node {
        public int data;
        public Node left;
        public Node right;
        boolean visited = false;

        public Node(int a) {
            this.data = a;
        }
    }

    public static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static int height(Node root) {
        if (root != null) {
            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}
