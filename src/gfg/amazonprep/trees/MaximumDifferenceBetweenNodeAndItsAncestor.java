package gfg.amazonprep.trees;

public class MaximumDifferenceBetweenNodeAndItsAncestor extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
//        Node c = new Node(1);
        root.left = a;
        root.right = b;
//        b.right = c;
        System.out.print(maxDiff(root));
    }

    public static int maxDiff(Node root) {
//        return maxDiff(root, Integer.MIN_VALUE);
        return Math.max(maxDiff(root.left, Math.max(root.data, root.data)), maxDiff(root.right, Math.max(root.data, root.data)));
    }

    public static int maxDiff(Node root, int max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max((max - root.data), Math.max(maxDiff(root.left, Math.max(root.data, max)), maxDiff(root.right, Math.max(root.data, max))));
    }
}
