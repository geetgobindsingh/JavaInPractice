package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(4);
        Node d = new Node(1);
        Node e = new Node(2);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        connect(root);
        System.out.print("Done");
    }

    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    public static void connect(Node p) {
        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(p);
        Node current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) {
                temp.add(current.left);
            }
            if (current.right != null) {
                temp.add(current.right);
            }
            if (queue.isEmpty()) {
                Node tempNode = null;
                while (!temp.isEmpty()) {
                    Node out = temp.poll();
                    if (tempNode == null) {
                        tempNode = out;
                    } else {
                        tempNode.nextRight = out;
                        tempNode = out;
                    }
                    queue.offer(out);
                }
            }
        }
    }
}
