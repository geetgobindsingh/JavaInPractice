package gfg.amazonprep.trees;

public class SymmetricTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(20);
//        Node c = new Node(40);
//        Node d = new Node(50);

        root.left = a;
        root.right = b;
//        a.left = c;
//        a.right = d;

        System.out.println(isSymmetric(root, root));
    }

    public static boolean isSymmetric(Node root1, Node root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.data == root2.data && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
