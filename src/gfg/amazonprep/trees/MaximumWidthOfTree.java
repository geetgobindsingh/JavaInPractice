package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree extends BaseTree {
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

        System.out.print(getMaxWidth(root));
    }

    public static int getMaxWidth(Node root) {
        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node current = null;
        int count = 0, level = 0;
        int maxCount = 1, maxLevel = 0;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) {
                temp.add(current.left);
            }
            if (current.right != null) {
                temp.add(current.right);
            }
            if (queue.isEmpty()) {
                level++;
                while (!temp.isEmpty()) {
                    Node out = temp.poll();
                    count++;
                    queue.offer(out);
                }
                if (maxCount < count) {
                    maxCount = count;
                    maxLevel = level;
                }
                count = 0;
            }
        }
        return maxLevel;
    }
}
