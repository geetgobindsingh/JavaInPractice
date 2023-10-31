package gfg.amazonprep.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthLargestElementInBST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(4);
        Node a = new Node(2);
        Node b = new Node(9);
        Node c = new Node(1);
        Node d = new Node(3);
        Node e = new Node(10);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        System.out.print(kthLargest(root, 3));
    }

    public static int kthLargest(Node root, int K) {
        if (root == null) return 0;
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root;
        int result = -1;
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
        for (int index = list.size() - 1; index >=0; index--) {
            if (K == 1) {
                result = list.get(index);
                break;
            } else {
                K--;
            }
        }
        return result;
    }
    public static int kthSmallest(Node root, int K) {
        if (root == null) return 0;
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node current = root;
        int result = -1;
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
        for (int index = 0; index <list.size(); index++) {
            if (K == 1) {
                result = list.get(index);
                break;
            } else {
                K--;
            }
        }
        return result;
    }

}
