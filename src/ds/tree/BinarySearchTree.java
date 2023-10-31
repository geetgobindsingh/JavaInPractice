package ds.tree;

public class BinarySearchTree extends BinaryTree {

    @Override
    protected void addNode(BTNode rootNode, BTNode dataNode) {
        if (rootNode.getData() > dataNode.getData()) {
            //LEFT SIDE
            if (rootNode.getLeftNode() != null) {
                addNode(rootNode.getLeftNode(), dataNode);
            } else {
                rootNode.setLeftNode(dataNode);
            }
        } else {
            //RIGHT SIDE
            if (rootNode.getRightNode() != null) {
                addNode(rootNode.getRightNode(), dataNode);
            } else {
                rootNode.setRightNode(dataNode);
            }
        }
    }
}
