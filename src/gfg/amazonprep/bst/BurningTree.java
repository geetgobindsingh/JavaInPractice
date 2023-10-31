package gfg.amazonprep.bst;

import java.util.*;

public class BurningTree extends BaseTree {
    public static void main(String[] args) {
        //1 2 3 4 5 N 7 8 N 10
//        Node root = new Node(1);
//        Node a = new Node(2);
//        Node b = new Node(3);
//        Node c = new Node(4);
//        Node d = new Node(5);
//        Node e = new Node(6);
//        Node f = new Node(7);
//        Node g = new Node(8);
//        Node h = new Node(9);
//        Node i = new Node(10);
//        root.left = a;
//        root.right = b;
//        a.left = c;
//        a.right = d;
//        d.left = f;
//        d.right = g;
//        b.right = e;
//        e.right = h;
//        h.right = i;

        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node f = new Node(7);
        Node g = new Node(8);
        Node i = new Node(10);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = f;
        c.left = g;
        d.left = i;

        System.out.print(minTime(root, 10));
    }

    public static int minTime(Node root, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!map.containsKey(current.data)) {
                map.put(current.data, new HashSet<>());
            }
            if (current.left != null) {
                Set<Integer> set = map.get(current.data);
                set.add(current.left.data);
                map.put(current.data, set);
                queue.add(current.left);
            }
            if (current.right != null) {
                Set<Integer> set = map.get(current.data);
                set.add(current.right.data);
                map.put(current.data, set);
                queue.add(current.right);
            }
        }

        for (Integer key : map.keySet()) {
            Set<Integer> set = map.get(key);
            for (Integer key2 : set) {
                Set<Integer> set2 = new HashSet<>();
                if (map.containsKey(key2)) {
                    set2 = map.get(key2);
                }
                set2.add(key);
                map.put(key2, set2);
            }
        }

        Stack<Set<Integer>> stack = new Stack<>();
        int count = 0;
        Set<Integer> t = new HashSet<>();
        t.add(target);
        stack.add(t);
        Set<Integer> processed = new HashSet<>();
        processed.add(target);
        while (!stack.isEmpty()) {
            Set<Integer> keySet = stack.pop();
            boolean added = false;
            for (Integer parentKey : keySet) {
                t = new HashSet<>();
                for (Integer key2 : map.get(parentKey)) {
                    if (!processed.contains(key2)) {
                        processed.add(key2);
                        t.add(key2);
                    }
                }
                if(!t.isEmpty()) {
                    added = true;
                    stack.add(t);
                }
            }
            if (added) {
                count++;
            }
        }
        return count;
    }
}
