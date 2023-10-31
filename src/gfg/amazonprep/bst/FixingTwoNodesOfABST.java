package gfg.amazonprep.bst;

public class FixingTwoNodesOfABST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(52);
        Node b = new Node(5);
        Node c = new Node(62);
        Node d = new Node(4);
        Node e = new Node(26);
        Node f = new Node(2);
        Node g = new Node(66);
        Node h = new Node(58);
        root.right = a;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        correctBST(root);
        System.out.print("\n");
        inOrderTraversal(root);
    }

    public static Node correctBST(Node root) {
        Node first = getCorruptNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE, new Node(-1));
        Node second = getCorruptNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE, first);
        System.out.print(first.data + " " );
        System.out.print(second.data);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        return root;
    }

    public static Node getCorruptNode(Node root, int min, int max, Node skip) {
        if (root == null) {
            return null;
        }

        if (root.data != skip.data && root.left == null && root.right == null) {
            return (root.data < max && root.data >= min) ? null : root;
        }

        Node left = getCorruptNode(root.left, min, root.data, skip);
        if (left != null && left.data != skip.data) {
            return left;
        }
        Node right = getCorruptNode(root.right, root.data, max, skip);
        if (right != null && right.data != skip.data) {
            return right;
        }
        return root.data != skip.data && root.data < max
                && root.data >= min
                && (root.left == null || root.left.data <= root.data)
                && (root.right == null || root.right.data > root.data) ? null : root;
    }
}
