package leetcode.medium;

import java.util.Stack;

public abstract class BaseTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {

        int index = 0;
        TreeNode node = null;
        int state = 0;

        public Pair(int index, TreeNode node, int state) {
            this.index = index;
            this.node = node;
            this.state = state;
        }
    }
    public static TreeNode generateTree(Integer[] ar) {
        int n = ar.length;
        Stack<Pair> st = new Stack<>();
        TreeNode root = new TreeNode(ar[0]);
        st.push(new Pair(0, root, 0));
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 0) {
                int childIndex = 2 * top.index + 1;
                if (childIndex < n && ar[childIndex] != null) {
                    Pair left = new Pair(childIndex, new TreeNode(ar[childIndex]), 0);
                    top.node.left = left.node;
                    st.push(left);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 1) {
                int childIndex = 2 * top.index + 2;
                if (childIndex < n && ar[childIndex] != null) {
                    Pair right = new Pair(childIndex, new TreeNode(ar[childIndex]), 0);
                    top.node.right = right.node;
                    st.push(right);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
    public static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
}
