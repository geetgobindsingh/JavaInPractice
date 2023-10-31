package gfg.amazonprep.bst;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorInABST extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(13);
        Node a = new Node(6);
        Node b = new Node(3);
        Node c = new Node(8);
        Node d = new Node(1);
        root.left = a;
        a.left = b;
        a.right = c;
        b.left = d;
        inOrderTraversal(root);
        System.out.print("\n");
        System.out.print(LCA(root, 6, 1).data);
    }

    public static Node LCA(Node root, int n1, int n2) {
        List<Node> pathOne = new LinkedList<>();
        Node current = root;
        while (current != null && current.data != n2) {
            pathOne.add(current);
            if (current.data < n2) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        pathOne.add(current);

        current = root;
        List<Node> pathTwo = new LinkedList<>();
        while (current != null && current.data != n1) {
            pathTwo.add(current);
            if (current.data < n1) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        pathTwo.add(current);
        int i = 0;
        int j = 0;
        while (i < pathOne.size() && j < pathTwo.size()) {
            if (pathOne.get(i).data == pathTwo.get(j).data) {
                i++;
                j++;
            } else {
                break;
            }
        }
        if (pathOne.size() < pathTwo.size()) {
            return pathOne.get(i - 1);
        } else {
            return pathTwo.get(j - 1);
        }
    }
}
