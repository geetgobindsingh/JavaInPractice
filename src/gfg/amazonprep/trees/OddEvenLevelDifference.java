package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenLevelDifference extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(50);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        System.out.print(getLevelDiff(root));
    }

    public static int getLevelDiff(Node root) {
        if (root == null) return -1;
        int evenSum = 0;
        int oddSum = 0;
        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        evenSum = evenSum + root.data;
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                temp.add(cur.left);
            }
            if (cur.right != null) {
                temp.add(cur.right);
            }
            if (queue.isEmpty()) {
                while (!temp.isEmpty()) {
                    Node n = temp.poll();
                    if (!flag) {
                        oddSum = oddSum + n.data;
                    } else {
                        evenSum = evenSum + n.data;
                    }
                    queue.add(n);
                }
                flag = !flag;
            }
        }
        return evenSum - oddSum;
    }
}
