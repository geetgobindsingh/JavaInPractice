package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalTraversalOfBinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        Node a6 = new Node(6);
        Node a7 = new Node(7);
        root.left = a2;
        root.right = a3;
        a2.left = a4;
        a3.right = a5;
        a4.right = a6;
        a5.left = a7;
        for (Integer i : verticalOrder(root)) {
            System.out.print(i + " ");
        }
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        verticalOrder(root, 0, map, 0);
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> keys = new ArrayList<Integer>(map.keySet());
        for (Integer key : keys) {
            TreeMap<Integer, List<Integer>> treeMap = map.get(key);
            for (List<Integer> l : treeMap.values()) {
                result.addAll(l);
            }
        }
        return result;
    }

    static void verticalOrder(Node root, int c, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, int level) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        if (map.containsKey(c)) {
            treeMap = map.get(c);
        }
        List<Integer> list = treeMap.get(level);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(root.data);
        treeMap.put(level, list);
        map.put(c, treeMap);
        verticalOrder(root.left, c - 1, map, level + 1);
        verticalOrder(root.right, c + 1, map, level + 1);
    }
}
