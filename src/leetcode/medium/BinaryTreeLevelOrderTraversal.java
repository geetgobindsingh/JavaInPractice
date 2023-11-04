package leetcode.medium;

import leetcode.hard.BinaryTreeMaximumPathSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
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
        for (List<Integer> l : obj.levelOrder(root)) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = q.poll();
                l.add(p.val);
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
            list.add(l);
        }
        return list;
    }
}
