package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree {


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree obj = new LowestCommonAncestorOfABinaryTree();
        System.out.print(obj.lowestCommonAncestor(generateTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // fast
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) { // slow
        List<Integer> listP = new ArrayList<>();
        List<Integer> listQ = new ArrayList<>();
        traverse(root, p, listP);
        traverse(root, q, listQ);
        int i = 0;
        int last = -1;
        while (Objects.equals(listP.get(i), listQ.get(i))) {
            last = listP.get(i);
            i++;
        }
        return new TreeNode(last);
    }

    private void traverse(TreeNode root, TreeNode t, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.val == t.val) {
            list.add(t.val);
            return;
        }
        traverse(root.left, t, list);
        if (list.size() > 0) {
            list.add(0, root.val);
            return;
        }
        traverse(root.right, t, list);
        if (list.size() > 0) {
            list.add(0, root.val);
        }
    }

    private static TreeNode generateTree(Integer[] ar) {
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
}
