package gfg.amazonprep.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseAlternateLevelsOfAPerfectBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(42);
        Node d = new Node(51);
        Node e = new Node(63);
        Node f = new Node(72);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        reverseAlternate(root);
        inOrderTraversal(root);
    }

    static void reverseAlternate(Node root) {
        if (root == null) return;
        List<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current = null;
        int level = 0;
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
                if (level % 2 != 0) {
                    int i = 0;
                    int j = temp.size() - 1;
                    while (i < j) {
                        Node left = temp.get(i);
                        Node right = temp.get(j);
                        int tempVal = left.data;
                        left.data = right.data;
                        right.data = tempVal;
                        i++;
                        j--;
                    }
                }
                queue.addAll(temp);
                temp.clear();
            }
        }
    }
}
