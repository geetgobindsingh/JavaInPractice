package gfg.amazonprep.trees;

import java.util.*;

public class LevelOrderTraversalInSpiralForm extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(9);
        Node a = new Node(8);
        Node b = new Node(11);
        Node l = new Node(4);
        Node c = new Node(10);
        Node d = new Node(12);
        Node e = new Node(3);
        Node f = new Node(7);
        Node g = new Node(2);
        Node h = new Node(6);
        Node i = new Node(1);
        Node j = new Node(5);
        Node k = new Node(0);

        root.left = a;
        root.right = b;
        a.left = l;
        b.left = c;
        b.right = d;
        l.left = e;
        l.right = f;

        e.left = g;
        f.left = h;

        g.left = i;
        h.left = j;

        i.left = k;

        printSpiral(root);
        System.out.println("\n");
        levelOrderTraversal(root);
    }

    public static void printSpiral(Node node) {
        List<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = true;
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
                queue.addAll(temp);
                if (!flag) {
                    Collections.reverse(temp);
                }
                for (Node n : temp) {
                    System.out.print(n.data + " ");
                }
                temp.clear();
                flag = !flag;
            }
        }
    }

}
