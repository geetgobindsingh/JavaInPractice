package DSAKiller.graph;

import java.util.ArrayList;
import java.util.TreeSet;
//TODO: @Difficult
public class RatInAMazeProblem {
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m.length; y++) {
                System.out.print(m[x][y] + " ");
            }
            System.out.print("\n");
        }

        for (String s : printPath(m, m.length)) {
            System.out.print(s + " ");
        }
    }

    public static ArrayList<String> printPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        TreeSet<String> treeSet = new TreeSet<>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return new ArrayList<>();
        }
        visited[0][0] = true;
        printPaths(m, n, visited, 0, 0, "", treeSet);
        return new ArrayList<>(treeSet);
    }

    public static void printPaths(int[][] m,
                                  int n,
                                  boolean[][] visited,
                                  int x, int y,
                                  String resultant,
                                  TreeSet<String> treeSet) {
        if (x == (n - 1) && y == (n - 1)) {
            treeSet.add(resultant);
            return;
        }
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, +1};
        String direction[] = {"U", "D", "L", "R"};
        for (int step = 0; step < 4; step++) {
            int nextX = x + dx[step];
            int nextY = y + dy[step];
            if (nextX >= 0 && nextY >= 0
                    && nextX < n && nextY < n
                    && !visited[nextX][nextY]
                    && m[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                printPaths(m, n, visited, nextX, nextY, resultant + direction[step], treeSet);
                visited[nextX][nextY] = false;
            }
        }
    }
}
