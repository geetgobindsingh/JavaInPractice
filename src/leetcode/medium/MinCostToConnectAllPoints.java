package leetcode.medium;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        MinCostToConnectAllPoints obj = new MinCostToConnectAllPoints();
        System.out.println(obj.minCostConnectPoints(new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        }));
        System.out.println(obj.minCostConnectPoints2(new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        }));
    }

    public static class Node {

        int val;

        int weight;

        List<Node> nbr;

        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
            this.nbr = new ArrayList<>();
        }
    }

    class Edge {
        int point1;
        int point2;
        int cost;

        public Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }


    public int minCostConnectPoints(int[][] points) {

        if (points == null || points.length == 0)
            return 0;

        int n = points.length;
        boolean[] visited = new boolean[n];

        //we only want n-1 edges if there are n points as we dont want a cycle
        int requiredEdges = n - 1;
        int minCost = 0;

        //we always want min cost to choose 1st, so lets use minheap based on cost
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        int[] coordinate1 = points[0];

        //find all possible paths from 0 to n and add its cost to minHeap
        //here indexes are considered as nodes
        for (int i = 1; i < points.length; i++) {
            int[] coordinate2 = points[i];
            int cost = Math.abs(coordinate2[0] - coordinate1[0])
                    + Math.abs(coordinate2[1] - coordinate1[1]);
            Edge e = new Edge(0, i, cost);
            minHeap.add(e);
        }

        //lets mark 0 as visited bcz we are gonna start from 0 -> finding minCost to another node
        visited[0] = true;

        //we will check till requiredEdges become 0, as we need know initial value was set to n-1
        while (!minHeap.isEmpty() && requiredEdges > 0) {
            Edge e = minHeap.poll();
            int point1 = e.point1;
            int point2 = e.point2;
            int cost = e.cost;

            //we took the shortest point and see if its already visited, if not lets explore
            if (!visited[point2]) {

                //add the cost and mark as visited
                minCost += cost;
                visited[point2] = true;

                //now lets explore from point 2 to all other possible nodes
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int distance = Math.abs(points[point2][0] - points[i][0])
                                + Math.abs(points[point2][1] - points[i][1]);

                        minHeap.add(new Edge(point2, i, distance));
                    }
                }

                //after this if loop is executed successfully we know we considered a edges, lets decrement it
                requiredEdges--;
            }
        }

        return minCost;
    }

    public int minCostConnectPoints2(int[][] points) { // prims algo
        int n = points.length;
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] s = points[i];
            graph.add(new Node(i, 0));
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int[] d = points[j];
                    int w = Math.abs(s[0] - d[0]) + Math.abs(s[1] - d[1]);
                    graph.get(i).nbr.add(new Node(j, w));
                }
            }
        }

        boolean visited[] = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        pq.add(graph.get(0));
        int totalWeight = 0;
        while (pq.size() > 0) {
            Node curr = pq.poll();
            if (visited[curr.val]) continue;
            visited[curr.val] = true;
            int wt = curr.weight;
            totalWeight = totalWeight + wt;
            for (Node node : graph.get(curr.val).nbr) {
                if (!visited[node.val]) {
                    pq.offer(node);
                }
            }
        }
        return totalWeight;
    }

}
