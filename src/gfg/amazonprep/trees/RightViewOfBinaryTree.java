package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = e;
        rightView(root);
    }

    public static void rightView(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        System.out.print(node.data + " ");
        Node current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.right != null) {
                temp.offer(current.right);
            }
            if (current.left != null) {
                temp.offer(current.left);
            }
            if (queue.isEmpty()) {
                boolean first = true;
                while (!temp.isEmpty()) {
                    if (first) {
                        first = false;
                        Node firstNode = temp.poll();
                        System.out.print(firstNode.data + " ");
                        queue.offer(firstNode);
                    } else {
                        queue.offer(temp.poll());
                    }
                }
            }
        }
    }
}
