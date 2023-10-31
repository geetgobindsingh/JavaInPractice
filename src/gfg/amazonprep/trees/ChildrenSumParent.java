package gfg.amazonprep.trees;

public class ChildrenSumParent extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(410);
        Node a = new Node(20);
        Node b = new Node(20);
//        Node c = new Node(40);
//        Node d = new Node(50);

        root.left = a;
        root.right = b;
//        a.left = c;
//        a.right = d;

        System.out.println(isSumProperty(root));
    }

    public static int isSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }
        int left = root.left != null ? root.left.data : 0;
        int right = root.right != null ? root.right.data : 0;
        return ((root.data == (left + right)) && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) ? 1 : 0;
    }
}
