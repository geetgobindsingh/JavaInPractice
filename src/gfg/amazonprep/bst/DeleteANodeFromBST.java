package gfg.amazonprep.bst;

public class DeleteANodeFromBST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(3);
        Node d = new Node(4);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        deleteNode(root, 3);
        inOrderTraversal(root);
        System.out.print("\n");
        deleteNode(root, 2);
        inOrderTraversal(root);

    }

    public static void deleteNode(Node root, int X) {
        if (root == null) return;
        if (root.data < X) {
            deleteNode(root.right, X);
        } else if (root.data > X) {
            deleteNode(root.left, X);
        } else {
            if (root.left == null) {

            } else if (root.right == null) {

            } else {
                root.data = minValue(root.right);
                deleteNode(root.right, root.data);
            }
        }
    }

    public static Node deleteNode1(Node root, int X) {
        if (root == null) return root;
        if (root.data < X) {
            return deleteNode1(root.right, X);
        } else if (root.data > X) {
            return deleteNode1(root.left, X);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = minValue(root.right);
                root.right = deleteNode1(root.right, root.data);
            }
        }
        return root;
    }

    private static int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            root = root.left;
            min = root.data;
        }
        return min;
    }
}
