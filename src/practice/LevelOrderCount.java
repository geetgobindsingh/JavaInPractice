package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class LevelOrderCount {

    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        LevelOrderCount obj = new LevelOrderCount();
        Node root = new Node(1);
        Node child2 = new Node(2);
        Node child3 = new Node(3);
        Node child4 = new Node(4);
        root.left = child2;
        root.right = child3;
        child2.left = child4;
        obj.BFS(root);
    }

    public void BFS(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        while (q.size() > 0) {
            System.out.println(q.size());
            for (int i = q.size() - 1; i >= 0; --i) {
                Node c = q.poll();
                if (c.left != null) {
                    q.offer(c.left);
                }
                if (c.right != null) {
                    q.offer(c.right);
                }
            }
        }
    }
}
