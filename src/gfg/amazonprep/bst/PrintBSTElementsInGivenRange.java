package gfg.amazonprep.bst;

import java.util.ArrayList;
import java.util.Stack;

public class PrintBSTElementsInGivenRange extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        root.right = a;
        a.right = b;
        b.right = c;
        c.right = d;
        for (Integer i : printNearNodes(root, 2, 4)) {
            System.out.print(i);
        }
    }

    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root;
        while (!done) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    current = stack.pop();
                    if (current.data >= low && current.data <= high) {
                        result.add(current.data);
                    }
                    current = current.right;
                }
            }
        }
        return result;
    }
}
