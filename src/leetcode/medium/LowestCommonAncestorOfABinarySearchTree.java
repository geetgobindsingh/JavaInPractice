package leetcode.medium;

public class LowestCommonAncestorOfABinarySearchTree extends BaseTree {
    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree obj = new LowestCommonAncestorOfABinarySearchTree();
        System.out.println(obj.lowestCommonAncestor(generateTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}), new TreeNode(2), new TreeNode(8)).val);
        System.out.println(obj.lowestCommonAncestor(generateTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}), new TreeNode(2), new TreeNode(4)).val);
        System.out.println(obj.lowestCommonAncestor(generateTree(new Integer[]{2,1,3}), new TreeNode(3), new TreeNode(1)).val);
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return null;
        if (root.val == p.val || root.val == q.val) return root;
        if (root.val > p.val && root.val < q.val) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val)  {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        return lca(root, p, q);
    }
}
