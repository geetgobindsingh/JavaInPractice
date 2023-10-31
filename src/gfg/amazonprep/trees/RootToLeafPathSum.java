package gfg.amazonprep.trees;

public class RootToLeafPathSum extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        root.left = a;
        root.right = b;
        a.left = c;
        System.out.println(hasPathSum(root, 2));
        System.out.println(hasPathSum(root, 3));
        System.out.println(hasPathSum(root, 4));
        System.out.println(hasPathSum(root, 7));
    }

    public static boolean hasPathSum(Node node, int sum) {
        if (node == null) return false;
        return hasPathSum(node.left, node.data, sum)
                || hasPathSum(node.right, node.data, sum);
    }

    public static boolean hasPathSum(Node node, int forward, int sum) {
        if (node == null) {
            return false;
        }
        return (node.left == null && node.right == null && (node.data + forward) == sum)
                || (hasPathSum(node.left, forward + node.data, sum)
                || hasPathSum(node.right, forward + node.data, sum));
    }
}
