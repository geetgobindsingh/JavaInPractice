package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalIteratively extends BaseTree {

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

        levelOrder(root);
        System.out.println("\n");
        preOrderTraversal(root);

    }

    public static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return result;
    }

    public static void levelOrder1(Node node) {
        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                temp.add(cur.left);
            }
            if (cur.right != null) {
                temp.add(cur.right);
            }
            if (queue.isEmpty()) {
                while (!temp.isEmpty()) {
                    queue.add(temp.poll());
                }
                System.out.print("$ ");
            }
        }
    }
}
