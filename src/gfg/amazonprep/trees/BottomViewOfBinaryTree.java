package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(20);
        Node a = new Node(8);
        Node b = new Node(22);
        Node c = new Node(5);
        Node d = new Node(3);
        Node e = new Node(25);
        Node f = new Node(10);
        Node g = new Node(14);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        d.left = f;
        d.right = g;
        for (Integer i : bottomView(root)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> bottomView(Node root) {
        Map<Integer, Pair> map = new TreeMap<>();
        bottomViewTraversal(root, 0, map, 0);

        ArrayList<Integer> result = new ArrayList<>();
        for (Pair pair : map.values()) {
            result.add(pair.second);
        }

        return result;
    }

    static class Pair {
        final int first;
        final int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void bottomViewTraversal(Node root, int c, Map<Integer, Pair> map, int level) {
        if (root == null) {
            return;
        }
        if (map.containsKey(c)) {
            Pair pair = map.get(c);
            if (level >= pair.first) {
                map.put(c, new Pair(level, root.data));
            }
        } else {
            map.put(c, new Pair(level, root.data));
        }
        bottomViewTraversal(root.left, c - 1, map, level + 1);
        bottomViewTraversal(root.right, c + 1, map, level + 1);
    }
}
