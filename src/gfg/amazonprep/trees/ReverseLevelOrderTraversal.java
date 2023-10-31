package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal extends BaseTree {
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

        reversePrint(root);
        levelOrderTraversal(root);
    }

    public static void reversePrint(Node node) {
        List<List<Node>> result = new ArrayList<>();
        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                temp.add(cur.left);
            }
            if (cur.right != null) {
                temp.add(cur.right);
            }
            if (queue.isEmpty()) {
                List<Node> list = new ArrayList<>();
                while (!temp.isEmpty()) {
                    Node n = temp.poll();
                    list.add(n);
                    queue.add(n);
                }
                result.add(list);
            }
        }
        for (int index = result.size() - 1; index >= 0; index--) {
            for (Node n : result.get(index)) {
                System.out.print(n.data + " ");
            }
        }
    }
}
