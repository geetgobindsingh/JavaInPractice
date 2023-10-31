package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class FindWhetherPathExist {
    public static void main(String[] args) {
        int M[][] = new int[][]{
                {3, 0, 0, 0},
                {0, 3, 3, 0},
                {0, 1, 0, 3},
                {0, 2, 3, 3}
        };
        System.out.print(is_possible(M, 4));
    }

    public static int is_possible(int M[][], int N) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        int startLoc = -1;
        int endLoc = -1;
        for (int index_i = 0; index_i < N; index_i++) {
            for (int index_j = 0; index_j < N; index_j++) {
                ArrayList<Integer> list = new ArrayList<>();
                if (M[index_i][index_j] != 0) {
                    if (M[index_i][index_j] == 1) {
                        startLoc = (index_i * N) + (index_j);
                    }
                    if (M[index_i][index_j] == 2) {
                        endLoc = (index_i * N) + (index_j);
                    }
                    // Left
                    if ((index_j != 0) && M[index_i][index_j - 1] != 0) {
                        visited.put((index_i * N) + (index_j - 1), false);
                        list.add((index_i * N) + (index_j - 1));
                    }
                    // Right
                    if (!(index_j == (N - 1)) && M[index_i][index_j + 1] != 0) {
                        visited.put((index_i * N) + (index_j + 1), false);
                        list.add((index_i * N) + (index_j + 1));
                    }
                    // Top
                    if (!(index_i == 0) && M[index_i - 1][index_j] != 0) {
                        visited.put(((index_i - 1) * N) + index_j, false);
                        list.add(((index_i - 1) * N) + index_j);
                    }
                    // Bottom
                    if (!(index_i == (N - 1)) && M[index_i + 1][index_j] != 0) {
                        visited.put(((index_i + 1) * N) + index_j, false);
                        list.add(((index_i + 1) * N) + index_j);
                    }
                    if (list.size() != 0) {
                        graph.put((index_i * N) + (index_j), list);
                    }
                }
            }
        }

        if (startLoc == -1 || endLoc == -1 || !graph.containsKey(startLoc) || !graph.containsKey(endLoc)) {
            return 0;
        }

        return isPathExist(graph, visited, startLoc, endLoc);
    }

    public static int isPathExist(HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Boolean> visited, int startLoc, int endLoc) {
        if (startLoc == endLoc) {
            return 1;
        }
        visited.put(startLoc, true);
        for (int child : graph.get(startLoc)) {
            if (visited.get(child) != null && !visited.get(child) && isPathExist(graph, visited, child, endLoc) == 1) {
                return 1;
            }
        }
        return -1;
    }
}
