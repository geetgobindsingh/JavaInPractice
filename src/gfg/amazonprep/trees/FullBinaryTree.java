package gfg.amazonprep.trees;

public class FullBinaryTree extends BaseTree {
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

        System.out.println(isFullTree(root));
    }

    public static boolean isFullTree(Node root) {
        if (root.left == null && root.right == null) {
             return true;
        }
        return root.left != null & root.right != null && isFullTree(root.left) && isFullTree(root.right);
    }
}
