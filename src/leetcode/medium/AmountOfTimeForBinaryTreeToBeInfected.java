package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class AmountOfTimeForBinaryTreeToBeInfected extends BaseTree {
    public static void main(String[] args) {
        AmountOfTimeForBinaryTreeToBeInfected obj = new AmountOfTimeForBinaryTreeToBeInfected();
        System.out.print(obj.amountOfTime(generateTree(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2}), 3));
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        parents(root, null, parents);
        return maxTime(find(root, start), parents, visited, 0);
    }

    private int maxTime(TreeNode root, HashMap<TreeNode, TreeNode> parents,
                        HashSet<TreeNode> visited, int time) {
        if (root == null || visited.contains(root)) return time;
        visited.add(root);
        int left = maxTime(root.left, parents, visited, time + 1);
        int right = maxTime(root.right, parents, visited, time + 1);
        int parent = maxTime(parents.get(root), parents, visited, time + 1);
        return Math.max(time, Math.max(parent, Math.max(left, right)));
    }

    private void parents(TreeNode root, TreeNode prev, HashMap<TreeNode, TreeNode> parents) {
        if (root == null) {
            return;
        }
        parents.put(root, prev);
        parents(root.left, root, parents);
        parents(root.right, root, parents);
    }

    private TreeNode find(TreeNode root, int start) {
        if (root == null || root.val == start) return root;
        TreeNode left = find(root.left, start);
        TreeNode right = find(root.right, start);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}
