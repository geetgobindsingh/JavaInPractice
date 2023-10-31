package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PrintAllNodesThatDontHaveSibling extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(20);
        Node c = new Node(40);
//        Node d = new Node(50);

        root.left = a;
        root.right = b;
        a.left = c;
//        a.right = d;

        printSibling(root);
    }

    public static void printSibling(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = null;
        stack.add(root);
        while (!done) {
            if (stack.isEmpty()) {
                done = true;
            } else {
                current = stack.pop();
                if (current.left != null && current.right == null) {
                    list.add(current.left.data);
                }
                if (current.right != null && current.left == null) {
                    list.add(current.right.data);
                }
                if (current.right != null) {
                    stack.add(current.right);
                }
                if (current.left != null) {
                    stack.add(current.left);
                }
            }
        }
        if (list.size() == 0) {
            System.out.print(-1);
        } else {
            Collections.sort(list);
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
