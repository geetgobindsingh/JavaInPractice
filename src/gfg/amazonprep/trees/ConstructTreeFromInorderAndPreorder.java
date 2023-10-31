package gfg.amazonprep.trees;

public class ConstructTreeFromInorderAndPreorder extends BaseTree {
    public static void main(String[] args) {
        int[] inOrder = new int[]{3, 2, 1, 4};
        int[] preOrder = new int[]{1, 2, 3, 4};
        inOrderTraversal(buildTree(inOrder, preOrder, inOrder.length));
    }

    public static Node buildTree(int inorder[], int preorder[], int n) {
        return buildTree(inorder, 0, n - 1, preorder, 0, n - 1);
    }

    public static Node buildTree(int inorder[],
                                 int inStart,
                                 int inEnd,
                                 int preorder[],
                                 int preStart,
                                 int preEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        Node node = new Node(preorder[preStart]);
        int offset = inStart;
        for (; offset < inEnd; ++offset) {
            if (inorder[offset] == node.data) {
                break;
            }
        }
        node.left = buildTree(inorder, inStart, inStart + offset, preorder, preStart + 1, preStart + offset - inStart);
        node.right = buildTree(inorder, offset + 1, inEnd, preorder, preStart + offset - inStart + 1, preEnd);
        return node;
    }
}
