package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LongestCycleInAGraph {
    public static void main(String[] args) {
        LongestCycleInAGraph obj = new LongestCycleInAGraph();
        System.out.println(obj.longestCycle(new int[]{3, 3, 4, 2, 3}));
    }

    static class Node {
        int val;
        List<Integer> component = new ArrayList<>();
        public Node(int val) {
            this.val = val;
        }
    }

    public int longestCycle(int[] edges) {
//        int[] inDegrees = new int[edges.length];
//        for (int i = 0; i < edges.length; ++i) {
//            if (edges[i] != -1) {
//                inDegrees[edges[i]]++;
//            }
//        }
//        Queue<Integer> q = new ArrayDeque<>();
//        for (int i = 0; i < edges.length; ++i) {
//            if (inDegrees[i] == 0) {
//                q.offer(i);
//            }
//        }
//        while (q.size() > 0) {
//
//        }
        int n = edges.length;
        List<Node>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
            if (edges[i] != -1) {
                graph[i].add(new Node(edges[i]));
            }
        }

        for (int i = 0; i < n; i++) {

        }

        return -1;
    }

    private void dfs(int i, List<Node>[] graph) {

    }
}
