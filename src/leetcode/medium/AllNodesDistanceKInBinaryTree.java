package leetcode.medium;

import java.util.*;

public class AllNodesDistanceKInBinaryTree extends BaseTree {
    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree obj = new AllNodesDistanceKInBinaryTree();
        for (int i : obj.distanceK(generateTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), 2)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    private Map<TreeNode, TreeNode> p;
    private Set<Integer> vis;
    private List<Integer> ans;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        p = new HashMap<>();
        vis = new HashSet<>();
        ans = new ArrayList<>();
        parents(root, null);
        dfs(target, k);
        return ans;
    }

    private void parents(TreeNode root, TreeNode prev) {
        if (root == null) {
            return;
        }
        p.put(root, prev);
        parents(root.left, root);
        parents(root.right, root);
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || vis.contains(root.val)) {
            return;
        }
        vis.add(root.val);
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        dfs(root.left, k - 1);
        dfs(root.right, k - 1);
        dfs(p.get(root), k - 1);
    }
}
