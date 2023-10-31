package gfg.amazonprep.trees;

public class MinimumDepthOfABinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(50);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        System.out.print(minDepth(root));
    }

    public static int minDepth(Node root) {
        if (root == null) return 0;
        return minDepth(root, 1, Integer.MAX_VALUE);
    }

    public static int minDepth(Node root, int depth, int min) {
        if (root == null) return min;
        if (root.left == null && root.right == null) {
            if (min > depth) {
                return depth;
            } else {
                return min;
            }
        }
        return Math.min(minDepth(root.left, depth + 1, min), minDepth(root.right, depth + 1, min));

    }
}
