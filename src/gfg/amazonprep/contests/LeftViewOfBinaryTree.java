package gfg.amazonprep.contests;

import gfg.amazonprep.trees.BaseTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(8);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        c.right = g;
        preOrderTraversal(root);
        System.out.print("\n");
        leftView(root);
    }

    public static void leftView(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> temp = new LinkedList<>();
        Node current = null;
        queue.offer(root);
        System.out.print(root.data + " ");
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) {
                temp.offer(current.left);
            }
            if (current.right != null) {
                temp.offer(current.right);
            }
            if (queue.isEmpty()) {
                boolean first = true;
                while (!temp.isEmpty()) {
                    if (first) {
                        Node next = temp.poll();
                        System.out.print(next.data + " ");
                        queue.offer(next);
                        first = false;
                    } else {
                        queue.offer(temp.poll());
                    }
                }
            }
        }
    }

}
