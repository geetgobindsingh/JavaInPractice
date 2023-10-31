package ds.tree;

public abstract class BinaryTree {

    private BTNode root = null;

    public void addNode(Integer data) {
        if (root != null) {
            addNode(root, new BTNode(data));
        } else {
            root = new BTNode(data);
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BTNode rootNode) {
        if (rootNode != null) {
            int leftTreeHeight = getHeight(rootNode.getLeftNode());
            int rightTreeHeight = getHeight(rootNode.getRightNode());
            return Math.max(leftTreeHeight, rightTreeHeight) + 1;
        }
        return 0;
    }

    public void printTree() {
        doIneOrderTraversal(root);
    }

    public BTNode getRoot() {
        return root;
    }

    private void doPreOrderTraversal(BTNode rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.getData() + " ");
            doPreOrderTraversal(rootNode.getLeftNode());
            doPreOrderTraversal(rootNode.getRightNode());
        }
    }

    private void doIneOrderTraversal(BTNode rootNode) {
        if (rootNode != null) {
            doIneOrderTraversal(rootNode.getLeftNode());
            System.out.print(rootNode.getData() + " ");
            doIneOrderTraversal(rootNode.getRightNode());
        }
    }

    private void doPostOrderTraversal(BTNode rootNode) {
        if (rootNode != null) {
            doPostOrderTraversal(rootNode.getLeftNode());
            doPostOrderTraversal(rootNode.getRightNode());
            System.out.print(rootNode.getData() + " ");
        }
    }


    protected abstract void addNode(BTNode rootNode, BTNode dataNode);
}
