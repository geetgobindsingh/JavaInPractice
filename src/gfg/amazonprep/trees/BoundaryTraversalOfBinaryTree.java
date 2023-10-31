package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BoundaryTraversalOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(20);
        Node a = new Node(8);
        Node b = new Node(22);
        Node c = new Node(4);
        Node d = new Node(12);
        Node e = new Node(25);
        Node f = new Node(10);
        Node g = new Node(14);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        d.left = f;
        d.right = g;
        for (Integer i : printBoundary(root)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> printBoundary(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        result.add(node.data);
        printBoundaryPre(node.left, result, -1, new ReachedLeaf());
        Stack<Integer> stack = new Stack<>();
        printBoundaryInversePre(node.right, result, stack, 1, new ReachedLeaf());
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    static class ReachedLeaf {
        boolean reachedLeaf;
    }

    public static void printBoundaryPre(Node node, ArrayList<Integer> result, int c, ReachedLeaf reachedLeaf) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            reachedLeaf.reachedLeaf = true;
            result.add(node.data);
            return;
        } else if (!reachedLeaf.reachedLeaf) {
            result.add(node.data);
        }
        printBoundaryPre(node.left, result, c - 1, reachedLeaf);
        printBoundaryPre(node.right, result, c + 1, reachedLeaf);
    }

    public static void printBoundaryInversePre(Node node, ArrayList<Integer> result, Stack<Integer> stack, int c, ReachedLeaf reachedLeaf) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            reachedLeaf.reachedLeaf = true;
            result.add(node.data);
            return;
        } else if (!reachedLeaf.reachedLeaf) {
            stack.add(node.data);
        }
        printBoundaryInversePre(node.right, result, stack, c + 1, reachedLeaf);
        printBoundaryInversePre(node.left, result, stack, c - 1, reachedLeaf);
    }

//    public static void printBoundaryInversePre(Node node, ArrayList<Integer> result, int c) {
//        if (node == null) {
//            return;
//        }
//        printBoundaryInversePre(node.right, result, c + 1);
//        if (c > 0 || (node.left == null && node.right == null)) {
//            result.add(node.data);
//        }
//    }
}
