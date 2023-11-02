package leetcode.medium;

import java.util.Stack;

public class CountNodesEqualToAverageOfSubtree {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        int state = 0;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {

        int index  = 0;
        TreeNode node = null;
        int state = 0;

        public Pair(int index, TreeNode node, int state) {
            this.index = index;
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{4, 8, 5, 0, 1, null, 6};
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

        CountNodesEqualToAverageOfSubtree obj = new CountNodesEqualToAverageOfSubtree();
        traversePre(root);
        System.out.println();
        traverseIn(root);
        System.out.println();
        System.out.println(obj.averageOfSubtree(root));
    }

    private static void traversePre(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        traversePre(root.left);
        traversePre(root.right);
    }

    private static void traverseIn(TreeNode root) {
        if (root == null) return;
        traverseIn(root.left);
        System.out.print(root.val + " ");
        traverseIn(root.right);
    }

    static class Couple {
        int sum = 0;
        int averageCount = 0;
        int childCount = 0;

        public Couple(int sum, int averageCount, int childCount) {
            this.sum = sum;
            this.averageCount = averageCount;
            this.childCount = childCount;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        return getAverageCouple(root).averageCount;
    }

    public Couple getAverageCouple(TreeNode root) {
        if (root == null) {
            return new Couple(0, 0, 0);
        }
        Couple left = getAverageCouple(root.left);
        Couple right = getAverageCouple(root.right);

        int sum = root.val + left.sum + right.sum;
        int totalChildren = 1 + left.childCount + right.childCount;

        boolean isValidAverage = (sum / totalChildren) == root.val;

        return new Couple(sum, left.averageCount + right.averageCount + (isValidAverage ? 1 : 0), totalChildren);
    }
}