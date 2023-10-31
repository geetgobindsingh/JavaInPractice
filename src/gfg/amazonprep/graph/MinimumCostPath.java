package gfg.amazonprep.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostPath {
    public static void main(String[] args) {
        String[] inp = "32 88 86 4 79 5 59 62 37".split(" ");
        int n = 3;
//        String[] inp = "42 93 07 14".split(" ");
//        int n = 2;
        int grid[][] = new int[n][n];
        for (int index_i = 0; index_i < n; index_i++) {
            for (int index_j = 0; index_j < n; index_j++) {
                grid[index_i][index_j] = Integer.parseInt(inp[index_i * n + index_j]);
            }
        }
        System.out.print(shortest(grid, n));
    }

    public static class Node {
        int x, y, dist;

        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.dist = d;
        }
    }

    static boolean isValid(int i, int j, int n) {
        return (i >= 0 && j >= 0 && i < n && j < n);
    }

    static boolean isEnd(int i, int j, int n) {
        return (i == (n - 1)) && (j == (n - 1));
    }

//    public static Node getMinNode(List<Node> Q) {
//        int min = Integer.MAX_VALUE;
//        Node result = null;
//        int index = -1;
//        for (int i = 0; i < Q.size(); i++) {
//            if (Q.get(i).dist < min) {
//                index = i;
//                min = Q.get(i).dist;
//            }
//        }
//        if (index != -1) {
//            result = Q.get(index);
//            Q.remove(index);
//        }
//        return result;
//    }

    private static int shortest(int M[][], int n) { //dijkstras
        Queue<Node> Q = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.dist, o2.dist);
            }
        });
        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int index_i = 0; index_i < n; index_i++) {
            for (int index_j = 0; index_j < n; index_j++) {
                dist[index_i][index_j] = Integer.MAX_VALUE;
                visited[index_i][index_j] = false;
//                System.out.print(M[index_i][index_j] + " ");
            }
//            System.out.print("\n");
        }
        dist[0][0] = M[0][0];
        Q.add(new Node(0, 0, M[0][0]));
        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            if (visited[cur.x][cur.y]) {
                continue;
            }
            visited[cur.x][cur.y] = true;
            // check Right
            if (isValid(cur.x, (cur.y + 1), n)
                    && !visited[cur.x][cur.y + 1]
                    && dist[cur.x][cur.y + 1] > dist[cur.x][cur.y] + M[cur.x][cur.y + 1]) {
                dist[cur.x][cur.y + 1] = dist[cur.x][cur.y] + M[cur.x][cur.y + 1];
                Q.add(new Node(cur.x, cur.y + 1, dist[cur.x][cur.y + 1]));
            }
            // check Bottom
            if (isValid(cur.x + 1, (cur.y), n) && !visited[cur.x + 1][cur.y]
                    && dist[cur.x + 1][cur.y] > dist[cur.x][cur.y] + M[cur.x + 1][cur.y]) {
                dist[cur.x + 1][cur.y] =
                        dist[cur.x][cur.y] + M[cur.x + 1][cur.y];
                Q.add(new Node(cur.x + 1, cur.y, dist[cur.x + 1][cur.y]));
            }
            // check Left
            if (isValid(cur.x, (cur.y - 1), n) && !visited[cur.x][cur.y - 1]
                    && dist[cur.x][cur.y - 1] >
                    dist[cur.x][cur.y] + M[cur.x][cur.y - 1]) {
                dist[cur.x][cur.y - 1] =
                        dist[cur.x][cur.y] + M[cur.x][cur.y - 1];
                Q.add(new Node(cur.x, cur.y - 1, dist[cur.x][cur.y - 1]));
            }
            // check Top
            if (isValid(cur.x - 1, cur.y, n) && !visited[cur.x - 1][cur.y]
                    && dist[cur.x - 1][cur.y] >
                    dist[cur.x][cur.y] + M[cur.x - 1][cur.y]) {
                dist[cur.x - 1][cur.y] =
                        dist[cur.x][cur.y] + M[cur.x - 1][cur.y];
                Q.add(new Node(cur.x - 1, cur.y, dist[cur.x - 1][cur.y]));
            }
        }
        return dist[n - 1][n - 1];
    }


    private static int shortest3(int M[][], int n) { //dp
        int i = 0, j = 0;
        int tc[][] = new int[n + 1][n + 1];

        tc[0][0] = M[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= n; i++) {
            tc[i][0] = tc[i - 1][0] + M[i - 1][0];
        }

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++) {
            tc[0][j] = tc[0][j - 1] + M[0][j - 1];
        }

        /* Construct rest of the tc array */
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                tc[i][j] = Math.min(tc[i - 1][j - 1], Math.min(tc[i - 1][j], tc[i][j - 1])) + M[i - 1][j - 1];
            }
        }

        return tc[n][n];
    }
}
