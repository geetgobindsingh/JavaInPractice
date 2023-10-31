package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        ValidateBinaryTreeNodes obj = new ValidateBinaryTreeNodes();
        System.out.println(obj.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        System.out.println(obj.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        System.out.println(obj.validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1}));
        System.out.println(obj.validateBinaryTreeNodes(6, new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1}));
        System.out.println(obj.validateBinaryTreeNodes(4, new int[]{3, -1, 1, -1}, new int[]{-1, -1, 0, -1}));
    }

    static class TreeNode {
        public int component = -1;
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (tree[i] == null) {
                tree[i] = new TreeNode(i);
            }
            if (leftChild[i] != -1) {
                int childIndex = leftChild[i];
                if (tree[childIndex] == null) {
                    tree[childIndex] = new TreeNode(childIndex);
                }
                tree[i].left = tree[childIndex];
            }
            if (rightChild[i] != -1) {
                int childIndex = rightChild[i];
                if (tree[childIndex] == null) {
                    tree[childIndex] = new TreeNode(childIndex);
                }
                tree[i].right = tree[childIndex];
            }
        }
        boolean[] visited = new boolean[n];
        Set<Integer> set = new HashSet<>();
        List<Integer> rootNode = findRootNode(tree);
        if (rootNode.size() != 1) {
            return false;
        }
        int rootIndex = rootNode.get(0);
        if (tree[rootIndex].component == -1) {
            tree[rootIndex].component = rootIndex;
        }
        if (!visited[rootIndex] && isCycleExist(tree[rootIndex], visited)) {
            return false;
        }
        set.add(tree[rootIndex].component);
        for (int i = 0; i < n; i++) {
            if (i == rootIndex) {
                continue;
            }
            if (tree[i].component == -1) {
                tree[i].component = i;
            }
            if (!visited[i] && isCycleExist(tree[i], visited)) {
                return false;
            }
            set.add(tree[i].component);
        }
        return set.size() == 1;
    }

    private List<Integer> findRootNode(TreeNode[] tree) {
        int[] indegree = new int[tree.length];
        for (int i = 0; i < tree.length; i++) {
            if (tree[i].left != null) {
                indegree[tree[i].left.val]++;
            }
            if (tree[i].right != null) {
                indegree[tree[i].right.val]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isCycleExist(TreeNode treeNode, boolean[] visited) {
        visited[treeNode.val] = true;
        boolean result = false;
        if (treeNode.left != null) {
            treeNode.left.component = treeNode.component;
            if (visited[treeNode.left.val]) {
                return true;
            }
            result = isCycleExist(treeNode.left, visited);
            if (result) {
                return true;
            }
        }
        if (treeNode.right != null) {
            treeNode.right.component = treeNode.component;
            if (visited[treeNode.right.val]) {
                return true;
            }
            result = isCycleExist(treeNode.right, visited);
            if (result) {
                return true;
            }
        }
        return result;
    }
}
