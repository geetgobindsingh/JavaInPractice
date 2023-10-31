package gfg.amazonprep.trees;

public class TreeFromPostorderAndInorder extends BaseTree {
    public static void main(String[] args) {
        int[] inOrder = new int[]{3, 2, 1, 4};
        int[] postOrder = new int[]{3, 2, 4, 1};
        inOrderTraversal(buildTree(inOrder, postOrder, inOrder.length));
    }

    public static Node buildTree(int in[], int post[], int n) {
        return buildTree(in, 0, n - 1, post, 0, n - 1);
    }

    public static Node buildTree(int inorder[],
                                 int inStart,
                                 int inEnd,
                                 int postorder[],
                                 int postStart,
                                 int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        Node node = new Node(postorder[postEnd]);
        int offset = inStart;
        for (; offset < inEnd; ++offset) {
            if (inorder[offset] == node.data) {
                break;
            }
        }
        node.left = buildTree(inorder, inStart, inStart + offset, postorder, postStart, postStart + offset - inStart - 1);
        node.right = buildTree(inorder, offset + 1, inEnd, postorder, postStart + offset - inStart, postEnd - 1);
        return node;
    }
}
