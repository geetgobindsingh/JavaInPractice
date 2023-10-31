package pepcoding.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    List<Node> children = new ArrayList<>();

    public Node(int val) {
        this.val = val;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    @Override
    public String toString() {
        return val + " ";
    }
}

public class LevelOrderLineWise {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node20 = new Node(20);
        Node node50 = new Node(50);
        Node node60 = new Node(60);
        node20.addChild(node50);
        node20.addChild(node60);
        Node node30 = new Node(30);
        Node node70 = new Node(70);
        node30.addChild(node70);
        Node node40 = new Node(40);
        Node node80 = new Node(80);
        Node node90 = new Node(90);
        node40.addChild(node80);
        node40.addChild(node90);
        root.addChild(node20);
        root.addChild(node30);
        root.addChild(node40);

        levelOrder2Q(root);
        System.out.print("\n");
        levelOrder1Q(root);
    }

    private static void levelOrder2Q(Node root) {
        Queue<Node> q = new LinkedList<>();
        Queue<Node> childrenQ = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() || !childrenQ.isEmpty()) {
            if (q.isEmpty()) {
                System.out.print("\n");
                q.addAll(childrenQ);
                childrenQ = new LinkedList<>();
            }
            Node current = q.remove();
            System.out.print(current);
            childrenQ.addAll(current.children);
        }
    }

    private static void levelOrder1Q(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int childrenCount = 0;
        do {
            childrenCount = q.size();
            while (childrenCount > 0) {
                Node current = q.remove();
                System.out.print(current);
                q.addAll(current.children);
                childrenCount--;
            }
            System.out.print("\n");
        } while (childrenCount != 0 || !q.isEmpty());
    }
}
