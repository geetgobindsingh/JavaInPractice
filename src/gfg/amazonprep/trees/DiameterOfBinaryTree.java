package gfg.amazonprep.trees;

public class DiameterOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

//        System.out.print(height(root));
        System.out.print(diameter(root));
    }

    public static int diameter(Node root) {
        return diameter(root, new Height(), new Height());
    }

    public static int diameter(Node root, Height left, Height right) { // trying in O(n)
        if (root == null) {
            return 0;
        }
        left.height++;
        right.height++;
        int diameter = left.height + right.height + 1;
        return Math.max(diameter, Math.max(diameter(root.left, left, right), diameter(root.right, left, right)));
    }

    static class Height {
        int height;
    }


    public static int diameter1(Node root) { // worst O(n^2)
        if (root == null) {
            return 0;
        }
        int diameter = height(root.left) + height(root.right) + 1;
        int left = diameter(root.left);
        int right = diameter(root.right);
        return Math.max(diameter, Math.max(left, right));
    }


    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}
