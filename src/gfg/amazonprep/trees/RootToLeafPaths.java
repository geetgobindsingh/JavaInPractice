package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.HashSet;

public class RootToLeafPaths extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(60);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        for (ArrayList<Integer> path : Paths(root)) {
            for (Integer node : path) {
                System.out.print(node + " ");
            }
            System.out.println("");
        }
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();
        DFS(root, visited, new ArrayList<>(), result);
        return result;
    }

    public static void DFS(Node root,
                           HashSet<Node> visited,
                           ArrayList<Integer> path,
                           ArrayList<ArrayList<Integer>> paths) {
        if (root == null) {
            return;
        }
        visited.add(root);
        path.add(root.data);
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        DFS(root.left, visited, new ArrayList<>(path), paths);
        DFS(root.right, visited, new ArrayList<>(path), paths);
    }
}
