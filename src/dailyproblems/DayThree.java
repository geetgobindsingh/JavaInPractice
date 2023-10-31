package dailyproblems;

import ds.tree.BTNode;
import ds.tree.BinarySearchTree;

public class DayThree {

    /*
    Problem Statement:

    Given the root to a binary tree, implement serialize(root),
    which serializes the tree into a string, and deserialize(s),
    which deserializes the string back into the tree.
     */
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addNode(2);
        binarySearchTree.addNode(3);
        binarySearchTree.addNode(1);
        String serialise = serialise(binarySearchTree.getRoot());
        System.out.println(serialise);
        System.out.println(deserialise(serialise).getData());
    }

    private static String serialise(BTNode root) {
        String result = "";
        if (root != null) {
            result = result + " " + root.getData();
            result = result + serialise(root.getLeftNode());
            result = result + serialise(root.getRightNode());
        } else {
            result = result + " -1";
        }
        return result;
    }

    private static BTNode deserialise(String serialise) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        String[] nodes = serialise.split(" ");
        binarySearchTree.addNode(Integer.parseInt(nodes[0]));
        return binarySearchTree.getRoot();
    }
}
