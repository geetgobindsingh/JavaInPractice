package gfg.amazonprep.bst;

public class CheckForBST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(12);
        Node a = new Node(1);
//        Node b = new Node(1);
//        Node c = new Node(1);
//        Node d = new Node(1);
//        Node e = new Node(1);
//        Node f = new Node(1);
//        Node g = new Node(1);
//        Node h = new Node(1);
//        Node i = new Node(1);


        root.left = a;
//        root.right = c;
//        a.left = c;
//        a.right = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;
//        d.left = h;
//        d.right = i;

        System.out.print(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return root.data < max && root.data >= min;
        }
        if(!isBST(root.left, min, root.data) || !isBST(root.right, root.data, max)) {
            return false;
        }
        return root.data < max
                && root.data >= min
                && (root.left == null || root.left.data <= root.data)
                && (root.right == null || root.right.data > root.data);
    }
}
