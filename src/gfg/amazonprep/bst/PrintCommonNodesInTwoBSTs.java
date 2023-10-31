package gfg.amazonprep.bst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class PrintCommonNodesInTwoBSTs extends BaseTree {
    public static void main(String[] args) {
        Node root1 = new Node(4);
        Node a = new Node(2);
        Node b = new Node(9);
        Node c = new Node(1);
        Node d = new Node(3);
        Node e = new Node(10);

        root1.left = a;
        root1.right = b;
        a.left = c;
        a.right = d;
        b.right = e;

        Node root2 = new Node(9);
        Node f = new Node(1);
        Node g = new Node(3);
        Node h = new Node(11);
        root2.left = f;
        root2.right = h;
        f.right = g;
        for (Integer i : printCommon(root1, root2)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> printCommon(Node root1, Node root2) {
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root1;
        HashSet<Integer> set = new HashSet<>();
        while (!done) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    set.add(current.data);
                    current = current.right;
                } else {
                    done = true;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        current = root2;
        done = false;
        while (!done) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    if (set.contains(current.data)) {
                        list.add(current.data);
                    }
                    current = current.right;
                } else {
                    done = true;
                }
            }
        }
        return list;
    }
}
