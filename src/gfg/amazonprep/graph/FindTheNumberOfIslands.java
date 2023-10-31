package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindTheNumberOfIslands {
    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>() {
//            {
//                add(new ArrayList<Integer>() {{
//                    add(1);
//                    add(1);
//                    add(0);
//                }});
//                add(new ArrayList<Integer>() {{
//                    add(0);
//                    add(0);
//                    add(1);
//                }});
//                add(new ArrayList<Integer>() {{
//                    add(1);
//                    add(0);
//                    add(1);
//                }});
//            }
//        };
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(1);
            }});
            add(new ArrayList<Integer>() {{
                add(0);
            }});
            add(new ArrayList<Integer>() {{
                add(0);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
            }});
            add(new ArrayList<Integer>() {{
                add(0);
            }});
        }};
        int N = A.size(), M = 1;
        System.out.print(findIslands(A, N, M));
    }

    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < (N * M); i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] dx = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = new int[]{0, 0, 1, -1, 1, -1, -1, 1};

        List<Integer> isLandsVertex = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A.get(i).get(j) == 0) {
                    continue;
                }
                isLandsVertex.add((i * M) + j);
                List<Integer> adjList = graph.get((i * M) + j);
                for (int step = 0; step < 8; step++) {
                    int x = i + dx[step];
                    int y = j + dy[step];
                    if (x < N && y < M
                            && x >= 0 && y >= 0
                            && A.get(x).get(y) == 1) {
                        adjList.add((x * M) + y);
                    }
                }
                graph.put((i * M) + j, adjList);
            }
        }

        boolean[] visited = new boolean[N * M];

        int islands = 0;
        for (Integer v : isLandsVertex) {
            if (!visited[v]) {
                islands = islands + dfs(v, graph, visited);
            }
        }
        return islands;
    }

    static int findIslands1(ArrayList<ArrayList<Integer>> A, int N, int M) {
        int matrix[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = A.get(i).get(j);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < (N * M); i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] dx = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = new int[]{0, 0, 1, -1, 1, -1, -1, 1};

        List<Integer> isLandsVertex = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                isLandsVertex.add((i * M) + j);
                List<Integer> adjList = graph.get((i * M) + j);
                for (int step = 0; step < 8; step++) {
                    int x = i + dx[step];
                    int y = j + dy[step];
                    if (x < N && y < M
                            && x >= 0 && y >= 0
                            && matrix[x][y] == 1) {
                        adjList.add((x * M) + y);
                    }
                }
                graph.put((i * M) + j, adjList);
            }
        }

        boolean[] visited = new boolean[N * M];

        for (int i = 0; i < (N * M); i++) {
            for (Integer u : graph.get(i)) {
                System.out.print(u + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        int islands = 0;
        for (int i = 0; i < (N * M); i++) {
            if (isLandsVertex.contains(i)) {
                islands = islands + dfs(i, graph, visited);
            }
        }
        return islands;
    }

    public static int dfs(int v, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        visited[v] = true;
        for (Integer u : graph.get(v)) {
            if (!visited[u]) {
                dfs(u, graph, visited);
            }
        }
        return 1;
    }
}
