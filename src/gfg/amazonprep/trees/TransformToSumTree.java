package gfg.amazonprep.trees;

public class TransformToSumTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(-2);
        Node b = new Node(6);
        Node c = new Node(8);
        Node d = new Node(-4);
        Node e = new Node(7);
        Node f = new Node(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        toSumTree(root);
        preOrderTraversal(root);
    }

    public static void toSumTree(Node root){
        int rootSum = buildSumTree(root);
    }

    public static int buildSumTree(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            int temp = root.data;
            root.data = 0;
            return temp;
        }
        int sum = buildSumTree(root.left) + buildSumTree(root.right);
        int temp = root.data;
        root.data = sum;
        return temp + sum;
    }
}
