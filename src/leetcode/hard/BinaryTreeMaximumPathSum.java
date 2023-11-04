package leetcode.hard;

public class BinaryTreeMaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = one;
        two.left = three;
        two.right = four;
        one.left = five;
        one.right = six;
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        System.out.println(obj.maxPathSum(root));
        System.out.println(obj.maxPathSum(new TreeNode(1, new TreeNode(-2), new TreeNode(3))));
    }

    static class Max {
        int max = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode node) {
        Max m = new Max();
        traverse(node, m);
        return m.max;
    }

    private int traverse(TreeNode node, Max m) {
        if (node == null) return 0;
        int left = Math.max(0, traverse(node.left, m));
        int right = Math.max(0, traverse(node.right, m));
        int sum = node.val + left + right;
        m.max = Math.max(m.max, sum);
        return node.val + Math.max(left, right);
    }
}
