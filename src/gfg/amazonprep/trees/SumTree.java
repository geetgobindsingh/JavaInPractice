package gfg.amazonprep.trees;

public class SumTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(26);
        Node a = new Node(10);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(6);
        Node e = new Node(1);
        Node f = new Node(2);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.print(isSumTree(root));
    }

    public static boolean isSumTree(Node node) {
        return isSumTree(node, node.left, node.right);
    }

    public static boolean isSumTree(Node node, Node l, Node r) {
        if (node == null || (node.right == null && node.left == null)) {
            return true;
        }
        int left = 0;
        int right = 0;
        if (l != null) {
            if (l.right == null && l.left == null) {
                left = l.data;
            } else {
                left = 2 * l.data;
            }
        }
        if (r != null) {
            if (r.right == null && r.left == null) {
                right = r.data;
            } else {
                right = 2 * r.data;
            }
        }
        return (node.data == (left + right)
                && isSumTree(node.left,
                node.left != null ? node.left.left : null,
                node.left != null ? node.left.right : null)
                && isSumTree(node.right,
                node.right != null ? node.right.left : null,
                node.right != null ? node.right.right : null));
    }
}
