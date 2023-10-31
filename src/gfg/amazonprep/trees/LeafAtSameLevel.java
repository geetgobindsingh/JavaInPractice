package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafAtSameLevel extends BaseTree {
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
        b.right = d;
        System.out.print(check(root));
    }

    public static boolean check(Node root) {
        List<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                temp.add(cur.left);
            }
            if (cur.right != null) {
                temp.add(cur.right);
            }
            if (queue.isEmpty()) {
                boolean containsLeafNode = false;
                int count = 0;
                for (Node n : temp) {
                    if (n.left == null && n.right == null) {
                        containsLeafNode = true;
                    } else {
                        count++;
                    }
                }
                if (containsLeafNode && count > 0) {
                    return false;
                }
                queue.addAll(temp);
                temp.clear();
            }
        }
        return true;
    }
}
