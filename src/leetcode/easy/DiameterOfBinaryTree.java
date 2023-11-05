package leetcode.easy;

import leetcode.medium.BaseTree;

public class DiameterOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        System.out.println(obj.diameterOfBinaryTree(generateTree(new Integer[]{1,2,3,4,5})));
        System.out.println(obj.diameterOfBinaryTree(generateTree(new Integer[]{1,2})));
    }

    static class Diameter {
        int h;
        int d;
        public Diameter(int h, int d) {
            this.h = h;
            this.d = d;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).d;
    }

    public Diameter diameter(TreeNode root) {
        if (root == null) return new Diameter(-1,0);
        Diameter left = diameter(root.left);
        Diameter right = diameter(root.right);
        int h = 1 + Math.max(left.h, right.h);
        int d = 2 + left.h + right.h;
        return new Diameter(h, Math.max(d, Math.max(left.d, right.d)));
    }
}
