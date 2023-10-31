package gfg.amazonprep.bst;


public class InsertANodeInABST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(1);
        Node b = new Node(4);
        root.left = a;
        root.right = b;
        preOrderTraversal(insert(root, 3));
        System.out.print("\n");
        inOrderTraversal(root);
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (root.data == key) {
            return root;
        }
        if (root.data > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }
}
