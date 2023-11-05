package leetcode.easy;

import leetcode.medium.BaseTree;

public class MaximumDepthOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();
        System.out.print(obj.maxDepth(generateTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
