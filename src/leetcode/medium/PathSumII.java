package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII extends BaseTree {

    public static void main(String[] args) {
        PathSumII obj = new PathSumII();
        for (List<Integer> list : obj.pathSum(generateTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22)) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, 0, targetSum, list, new ArrayList<>());
        return list;
    }

    private void traverse(TreeNode root, int sum, int targetSum, List<List<Integer>> result, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        } else {
            list.add(root.val);
            traverse(root.left, sum, targetSum, result, list);
            traverse(root.right, sum, targetSum, result, list);
            list.remove(list.size() - 1);
        }

    }
}
