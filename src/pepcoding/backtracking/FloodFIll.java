package pepcoding.backtracking;

import java.util.Scanner;

public class FloodFIll {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    private static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {
        int rows = maze.length;
        int cols = maze[0].length;
        if (sr < 0 || sc < 0 || sr == rows || sc == cols || maze[sr][sc] == 1 || visited[sr][sc]) {
            return;
        }
        if (sr == rows - 1 && sc == cols - 1) {
            System.out.println(asf);
            return;
        }
        visited[sr][sc] = true;
        floodfill(maze, sr + 1, sc, asf + "d", visited);
        floodfill(maze, sr, sc + 1, asf + "r", visited);
        floodfill(maze, sr - 1, sc, asf + "t", visited);
        floodfill(maze, sr, sc - 1, asf + "l", visited);
        visited[sr][sc] = false;
    }
}
