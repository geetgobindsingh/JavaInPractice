package gfg.amazonprep.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToBST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(50);

        root.left = a;
        root.right = b;
        a.left = c;
        c.right = d;
        inOrderTraversal(binaryTreeToBST(root));
    }

    public static Node binaryTreeToBST(Node root) {
        Node bstRoot = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            bstRoot = insert(bstRoot, current.data);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return bstRoot;
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
