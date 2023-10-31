package gfg.amazonprep.trees;

public class SumOfLeftLeafNodes extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = e;
        System.out.print(leftLeavesSum(root));
    }

    public static int leftLeavesSum(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return (leftLeavesSum(root.left) + leftLeavesSum(root.right) + ((root.left != null && root.left.left == null && root.left.right == null) ? root.left.data : 0));
    }
}
