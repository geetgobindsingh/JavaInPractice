package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.Queue;
//TODO: @Interesting
public class MakeBinaryTreeFromLinkedList extends BaseTree {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node a = new Node(20);
        head.next = a;
        Node b = new Node(30);
        a.next = b;
        Node c = new Node(40);
        b.next = c;
        preOrderTraversal(convert(head, null));
    }

    public static Tree convert(Node head, Tree node) {
        Queue<Tree> queue = new LinkedList<>();
        Tree root = null;
        if (head != null) {
            root = new Tree(head.data);
            queue.add(root);
            head = head.next;
        }
        if (head == null) {
            return root;
        }
        while (!queue.isEmpty()) {
            Tree cur = queue.poll();
            if (head != null) {
                cur.left = new Tree(head.data);
                queue.add(cur.left);
                if (head.next != null) {
                    cur.right = new Tree(head.next.data);
                    queue.add(cur.right);
                    head = head.next.next;
                } else {
                    head = head.next;
                }
            }
        }
        return root;
    }

    public static void preOrderTraversal(Tree root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

}
