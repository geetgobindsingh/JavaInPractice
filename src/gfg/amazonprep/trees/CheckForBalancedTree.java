package gfg.amazonprep.trees;

public class CheckForBalancedTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(10);
        Node b = new Node(39);
        Node c = new Node(5);
        root.left = a;
        root.right = b;
        a.left = c;
        System.out.println(isBalanced(root));
    }

    //Fastest
    static boolean isBalanced = true;

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        height(root);
        return isBalanced;
    }

    public static int height(Node root) {
        if (root != null && isBalanced) {
            int left = height(root.left);
            int right = height(root.right);
            if (Math.abs(left - right) >= 2) {
                isBalanced = false;
            }
            return Math.max(left, right) + 1;
        }
        return 0;
    }


    //Faster
    static class Height {
        int height = 0;
    }

    public static boolean isBalanced2(Node root) {
        return isBalanced(root, new Height());
    }

    public static boolean isBalanced(Node root, Height height) {
        if (root != null) {
            Height leftHeight = new Height();
            Height rightHeight = new Height();
            boolean isBalancedLeftSubTree = isBalanced(root.left, leftHeight);
            boolean isBalancedRightSubTree = isBalanced(root.right, rightHeight);

            height.height = Math.max(leftHeight.height, rightHeight.height) + 1;

            int heightDif = Math.abs(leftHeight.height - rightHeight.height);
            if (heightDif >= 2) {
                return false;
            }
            return isBalancedLeftSubTree && isBalancedRightSubTree;
        }
        height.height = 0;
        return true;
    }

    // Slower
    public static boolean isBalanced1(Node root) {
        if (root == null) {
            return true;
        }
        int heightDif = Math.abs(height(root.left) - height(root.right));
        return (heightDif <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
}
