package ds.tree;

public class BTNode {
    private Integer data;
    private BTNode leftNode = null;
    private BTNode rightNode = null;

    public BTNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BTNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BTNode leftNode) {
        this.leftNode = leftNode;
    }

    public BTNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BTNode rightNode) {
        this.rightNode = rightNode;
    }

}
