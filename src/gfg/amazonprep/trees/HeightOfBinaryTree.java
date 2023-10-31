package gfg.amazonprep.trees;

public class HeightOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(5);
        Node b = new Node(4);
        Node c = new Node(10);
        Node d = new Node(8);
        Node e = new Node(8);
        Node f = new Node(6);
        Node g = new Node(5);

        root.left = a;
        a.left = b;
        a.right = c;
        c.left = g;
        b.right = d;
        d.left = e;
        d.right = f;
        System.out.print(height(root));

    }


}
