package gfg.amazonprep.trees;

public class NumberOfTurnsInBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(6);
        Node e = new Node(10);
        root.left = a;
        root.right = b;
        a.right = c;
        a.right = d;
    }

    static int NumberOfTurns(Node root, int first, int second) {
        return 1;
    }
}
