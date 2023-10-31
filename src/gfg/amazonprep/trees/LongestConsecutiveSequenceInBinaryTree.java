package gfg.amazonprep.trees;

public class LongestConsecutiveSequenceInBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        root.left = a;
        a.left = b;
        b.right = c;
        System.out.println(longestConsecutive(root));
    }

    public static int longestConsecutive(Node root) {
        return longCon(root, -1);
    }

    public static int longCon(Node root, int val) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return val;
            }
            int left = -1;
            int right = -1;
            if (root.left != null) {
                if (((root.data - root.left.data) == -1)) {
                    if (val == -1) {
                        val = 1;
                    }
                    left = longCon(root.left, val + 1);
                } else {
                    left = longCon(root.left, -1);
                }
            }
            if (root.right != null) {
                if (((root.data - root.right.data) == -1)) {
                    if (val == -1) {
                        val = 1;
                    }
                    right = longCon(root.right, val + 1);
                } else {
                    right = longCon(root.right, -1);
                }
            }
            return Math.max(val, Math.max(left, right));
        }
        return val;
    }

}
