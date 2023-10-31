package leetcode.medium;

import java.util.*;

public class ColoringABorder {
    public static void main(String[] args) {
        ColoringABorder obj = new ColoringABorder();
        obj.displayArray(obj.colorBorderBFS(new int[][]{{1, 2, 1, 2, 1, 2},
                {2, 2, 2, 2, 1, 2},
                {1, 2, 2, 2, 1, 2}}, 1, 3, 3));
        obj.displayArray(obj.colorBorderDFS(new int[][]{{1, 2, 1, 2, 1, 2},
                {2, 2, 2, 2, 1, 2},
                {1, 2, 2, 2, 1, 2}}, 1, 3, 3));
    }

    public int[][] colorBorderDFS(int[][] grid, int r0, int c0, int color) {

        int n = grid.length;
        int m = grid[0].length;

        if (grid[r0][c0]==color)
            return grid;

        boolean[][] visited = new boolean[n][m];
        dfs(grid, r0, c0, grid[r0][c0], visited, color, n, m);

        return grid;

    }

    public void dfs(int[][] grid, int i, int j, int col, boolean[][] visited, int target, int n, int m){

        if (i>n-1 || i<0 || j>m-1 || j<0 || grid[i][j]!=col || visited[i][j])
            return;

        visited[i][j] = true;
        boolean border = false;

        if (i==0 || j==0 || j==m-1 || i==n-1 ||
                grid[i+1][j]!=col ||
                grid[i-1][j]!=col ||
                grid[i][j-1]!=col ||
                grid[i][j+1]!=col){
            border = true;
            // grid[i][j] = target;
        }


        dfs(grid, i+1, j, col, visited, target, n, m);
        dfs(grid, i-1, j, col, visited, target, n, m);
        dfs(grid, i, j+1, col, visited, target, n, m);
        dfs(grid, i, j-1, col, visited, target, n, m);

        if (border) {
            grid[i][j] = target;
        }
        displayArray(grid);

    }

    public void displayArray(int[][] ar) {
        for (int[] an : ar) {
            for (int j : an) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    static class Pair {
        int x; int y;
        boolean isCenter = false;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] colorBorderBFS(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Stack<Pair> st = new Stack<>();
        Deque<Pair> q = new ArrayDeque<>();
        Pair op = new Pair(row, col);
        q.offer(op);
        st.push(op);
        int t = grid[row][col];
        while (q.size() > 0) {
            for (int i = q.size(); i > 0; --i) {
                Pair p = q.poll();
                grid[p.x][p.y] = -t;
                int count = 0;
                for (int d[] : directions) {
                    int x = p.x + d[0];
                    int y = p.y + d[1];
                    if (isValid(x, y, m, n)) {
                        if (grid[x][y] == t || grid[x][y] == -t) {
                            count++;
                        }
                        if (grid[x][y] == t) {
                            op = new Pair(x, y);
                            q.offer(op);
                            st.push(op);
                        }
                    }
                }
                p.isCenter = (count == directions.length);
            }
            displayArray(grid);
        }
        while (st.size() > 0) {
            Pair p = st.pop();
            if (p.isCenter) {
                grid[p.x][p.y] = t;
            } else {
                grid[p.x][p.y] = color;
            }
        }
        return grid;
    }

    public boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && y >= 0 && x < m && y < n);
    }
}
