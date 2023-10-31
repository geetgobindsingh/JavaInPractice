package pepcoding.binaryTrees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveLeaves {
    public static void main(String[] args) {
        Node root = new Node(1, null, null);
        Node a2 = new Node(2, null, null);
        Node a3 = new Node(3, null, null);
        Node a4 = new Node(4, null, null);
        Node a5 = new Node(5, null, null);
        Node a6 = new Node(6, null, null);
        Node a7 = new Node(7, null, null);
        root.left = a2;
        root.right = a3;
        a2.left = a4;
        a3.right = a5;
        a4.right = a6;
        a5.left = a7;
        bfsDisplay(root);
        removeLeaves(root);
        bfsDisplay(root);
        removeLeaves2(root);
        bfsDisplay(root);
    }

    private static void removeLeaves(Node root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            root.left = null;
        }
        if (root.right != null && root.right.left == null && root.right.right == null) {
            root.right = null;
        }
        removeLeaves(root.left);
        removeLeaves(root.right);
    }

    private static Node removeLeaves2(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves2(root.left);
        root.right = removeLeaves2(root.right);
        return root;
    }

    private static void bfsDisplay(Node root) {
        int height = getHeight(root);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        getWidth(root, 0, set);
        int min = 0;
        int max = 0;
        for (int key : set) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        int width = max + Math.abs(min);
        System.out.print("\nTree:(width:" + width + ", height" + height + ")\n");
        Queue<Node> q = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0 || q2.size() > 0) {
            if (q.isEmpty()) {
                q.addAll(q2);
                q2.clear();
                System.out.print("\n");
            }
            Node curr = q.poll();
            if (curr == null) {
                System.out.print("-");
            } else {
                System.out.print(curr.val);
                q2.offer(curr.left);
                q2.offer(curr.right);
            }
        }
    }

    private static void getWidth(Node root, int shift, Set<Integer> set) {
        if (root == null) return;
        set.add(shift);
        getWidth(root.left, shift + 1, set);
        getWidth(root.right, shift - 1, set);
    }

    private static int getHeight(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
