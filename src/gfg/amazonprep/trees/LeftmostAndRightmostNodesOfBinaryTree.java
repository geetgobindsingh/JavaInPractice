package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftmostAndRightmostNodesOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        printCorner(root);
    }

    public static void printCorner(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> temp = new ArrayList<>();
        queue.add(node);
        System.out.print(node.data + " ");
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                temp.add(cur.left);
            }
            if (cur.right != null) {
                temp.add(cur.right);
            }
            if (queue.isEmpty()) {
                if (!temp.isEmpty()) {
                    if (temp.size() > 1) {
                        System.out.print(temp.get(0).data + " ");
                        System.out.print(temp.get(temp.size() - 1).data + " ");
                    } else {
                        System.out.print(temp.get(0).data + " ");
                    }
                    for (Node t : temp) {
                        queue.add(t);
                    }
                    temp.clear();
                }
            }
        }
    }
}
