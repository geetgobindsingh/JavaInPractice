package gfg.amazonprep.trees;

public class MinDistanceBetweenTwoGivenNodesOfABinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(3);
        Node b = new Node(60);
        Node c = new Node(4);
        Node d = new Node(83);
        root.left = a;
        root.right = b;
        a.right = c;
        b.right = d;
        System.out.print(findDist(root, 4, 83));
    }

    static int findDist(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);
        Height l = new Height();
        Height r = new Height();
        height(lca, a, l);
        int heightLeft = l.height;
        height(lca, b, r);
        int heightRight = r.height;
        return heightLeft + heightRight;
    }

    static class Height {
        int height;
    }

    static Node height(Node root, int a, Height h) {
        if (root == null) {
            return null;
        }
        if (root.data == a) {
            return root;
        }
        Node left = height(root.left, a, h);
        if (left != null) {
            h.height++;
        }
        Node right = height(root.right, a, h);
        if (right != null) {
            h.height++;
        }
        return left != null ? left : right;
    }

    static Node findLCA(Node root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) {
            return root;
        }
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

}
