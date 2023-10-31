package gfg.amazonprep.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MedianOfBST extends BaseTree {
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

        findMedian(root1);
        System.out.print("\n");
        inOrderTraversal(root1);
    }

    public static void findMedian(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root;
        List<Integer> list = new ArrayList<>();
        while (!done) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    current = stack.pop();
                    list.add(current.data);
                    current = current.right;
                }
            }
        }
        if (list.size() % 2 == 0) {
            double a = list.get(((list.size() / 2) - 1));
            double b = list.get((list.size() / 2));
            double result = ((a + b) / 2.0);
            int temp = (int) result;
            if (result == temp) {
                System.out.print(temp);
            } else {
                System.out.print(result);
            }
        } else {
            int temp = (int) list.get(((list.size() + 1) / 2) - 1);
            System.out.print(temp);
        }
    }
}
