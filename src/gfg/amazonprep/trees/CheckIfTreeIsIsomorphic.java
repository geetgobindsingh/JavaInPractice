package gfg.amazonprep.trees;

public class CheckIfTreeIsIsomorphic extends BaseTree {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);

        System.out.print(isIsomorphic(root1, root1));
    }

    public static boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }

        return root1.data == root2.data
                && (isIsomorphic(root1.left, root2.left) || isIsomorphic(root1.left, root2.right))
                && (isIsomorphic(root1.right, root2.right) || isIsomorphic(root1.right, root2.left));
    }
}
