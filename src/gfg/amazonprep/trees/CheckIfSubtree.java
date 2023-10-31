package gfg.amazonprep.trees;

public class CheckIfSubtree extends BaseTree {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node a1 = new Node(2);
        Node b1 = new Node(3);
        Node c1 = new Node(4);
        root1.left = a1;
        root1.right = b1;
        b1.left = c1;

        preOrderTraversal(root1);
        System.out.println("");
        Node root2 = new Node(3);
        Node a2 = new Node(4);
        root2.left = a2;
        preOrderTraversal(root2);
        System.out.println("");
        System.out.println(isSubtree(root1, root2));
    }

    public static boolean isSubtree(Node T, Node S) {
        if (T == null) {
            return false;
        }
        if (T.data == S.data) {
            boolean result = isSame(T, S);
            if (result) return result;
        }
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static boolean isSame(Node root1, Node root2) {
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
                && (isSame(root1.left, root2.left))
                && (isSame(root1.right, root2.right));
    }
}
