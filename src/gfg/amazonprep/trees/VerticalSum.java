package gfg.amazonprep.trees;

import java.util.*;

public class VerticalSum extends BaseTree {
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
        for (Integer i : verticalSum(root)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        traverseTree(root, 0, map);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            result.add(map.get(key));
        }
        return result;
    }

    public static void traverseTree(Node root, int key, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + root.data);
        } else {
            map.put(key, root.data);
        }
        traverseTree(root.left, key - 1, map);
        traverseTree(root.right, key + 1, map);
    }
}
