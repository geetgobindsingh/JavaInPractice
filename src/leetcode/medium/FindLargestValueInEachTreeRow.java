package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow obj = new FindLargestValueInEachTreeRow();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        root.right = new TreeNode(2, null, new TreeNode(9));
        for (int i : obj.largestValues(root)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (q.size() > 0) {
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                TreeNode r = q.poll();
                if (r.left != null) {
                    q.offer(r.left);
                }
                if (r.right != null) {
                    q.offer(r.right);
                }
                max = Math.max(max, r.val);
            }
            result.add(max);
        }
        return result;
    }
}
