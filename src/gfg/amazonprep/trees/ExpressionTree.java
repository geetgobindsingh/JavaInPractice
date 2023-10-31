package gfg.amazonprep.trees;

public class ExpressionTree extends BaseTree {

    static class Node {
        String data;
        Node left;
        Node right;
        boolean visited = false;

        public Node(String a) {
            this.data = a;
        }
    }

    public static void main(String[] args) {
        Node root = new Node("+");
        Node a = new Node("*");
        Node b = new Node("-");
        Node c = new Node("5");
        Node d = new Node("4");
        Node e = new Node("100");
        Node f = new Node("20");

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        System.out.println(evalTree(root));

    }

    public static int evalTree(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return Integer.parseInt(root.data);
            }
            if (root.data.equalsIgnoreCase("+")) {
                return evalTree(root.left) + evalTree(root.right);
            }
            if (root.data.equalsIgnoreCase("*")) {
                return evalTree(root.left) * evalTree(root.right);
            }
            if (root.data.equalsIgnoreCase("-")) {
                return evalTree(root.left) - evalTree(root.right);
            }
            if (root.data.equalsIgnoreCase("/")) {
                return evalTree(root.left) / evalTree(root.right);
            }
        }
        return 0;
    }
}
