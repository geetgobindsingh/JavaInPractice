package gfg.amazonprep.trees;

import java.util.*;

public class CheckIfTwoNodesAreCousins extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);

        root.left = a;
        root.right = b;
        a.left = c;
        b.right = d;
        System.out.print(Solution.isCousins(root, 5, 4));
    }


    static class Solution { // Only working solution
        static Map<Integer, Integer> depth;
        static Map<Integer, Node> parent;

        public static boolean isCousins(Node root, int x, int y) {
            depth = new HashMap();
            parent = new HashMap();
            dfs(root, null);
            return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
        }

        public static void dfs(Node node, Node par) {
            if (node != null) {
                depth.put(node.data, par != null ? 1 + depth.get(par.data) : 0);
                parent.put(node.data, par);
                dfs(node.left, node);
                dfs(node.right, node);
            }
        }
    }

    public static boolean isCousins(Node root, int a, int b) { // still failing one sol
        return level(root, a, 1) == level(root, b, 1) && !isSiblings(root, a, b);
    }

    public static int level(Node root, int a, int level) {
        if (root == null) {
            return 0;
        }

        if (root.data == a) {
            return level;
        }

        int left = level(root.left, a, level + 1);
        if (left != 0) {
            return left;
        }
        return level(root.right, a, level + 1);
    }

    public static boolean isSiblings(Node root, int a, int b) {
        if (root != null && root.left != null && root.right != null) {
            return ((root.left.data == a && root.right.data == b)
                    || (root.left.data == b && root.right.data == a))
                    || isSiblings(root.left, a, b)
                    || isSiblings(root.right, a, b);
        }
        return false;
    }

    public static boolean isCousins1(Node root, int a, int b) { // one test case failed
        Queue<Node> temp = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.left != null
                    && cur.right != null
                    && ((cur.left.data == a && cur.right.data == b)
                    || (cur.left.data == b && cur.right.data == a))) {
                return false;
            }

            if (cur.left != null) {
                temp.add(cur.left);
            }
            if (cur.right != null) {
                temp.add(cur.right);
            }
            if (queue.isEmpty()) {
                set.clear();
                while (!temp.isEmpty()) {
                    Node tep = temp.poll();
                    set.add(tep.data);
                    queue.add(tep);
                }
                if (set.contains(a) && set.contains(b)) {
                    return true;
                }
            }
        }
        return false;
    }
}
