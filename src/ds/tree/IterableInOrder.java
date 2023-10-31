package ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterableInOrder {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addNode(4);
        binarySearchTree.addNode(1);
        binarySearchTree.addNode(2);
        binarySearchTree.addNode(3);

        List<BTNode> getInorderList = getInorderList(binarySearchTree.getRoot());
        for (BTNode node : getInorderList) {
            System.out.print(node.getData() + " ");
        }
    }

    private static List<BTNode> getInorderList(BTNode root) {
        List<BTNode> result = new ArrayList<>();
        Stack<BTNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeftNode();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            result.add(root);
            root = root.getRightNode();
        }
        return result;
    }

//    private static List<BTNode> getInorderList(BTNode root) {
//        List<BTNode> result = new ArrayList<>();
//        if (root != null) {
//            BTNode leftNode = root.getLeftNode();
//            Stack<BTNode> stack = new Stack<>();
//            while (leftNode != null || !stack.isEmpty()) {
//                if (leftNode.getLeftNode() != null && !result.contains(leftNode.getLeftNode())) {
//                    leftNode = leftNode.getLeftNode();
//                    continue;
//                }
//                result.add(leftNode);
//                stack.push(leftNode);
//                if (leftNode.getRightNode() != null) {
//                    leftNode = leftNode.getRightNode();
//                } else {
//                    leftNode = stack.pop();
//                    if (stack.isEmpty()) {
//                        leftNode = null;
//                    }
//                }
//            }
//            result.add(root);
//            BTNode rightNode = root.getRightNode();
//            while (rightNode != null || !stack.isEmpty()) {
//                if (rightNode.getLeftNode() != null && !result.contains(rightNode.getLeftNode())) {
//                    rightNode = rightNode.getLeftNode();
//                    continue;
//                }
//                result.add(rightNode);
//                stack.push(rightNode);
//                if (rightNode.getRightNode() != null) {
//                    rightNode = rightNode.getRightNode();
//                } else {
//                    rightNode = stack.pop();
//                    if (stack.isEmpty()) {
//                        rightNode = null;
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
