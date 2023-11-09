package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();
//        System.out.println(obj.numIslands(new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        }));
        System.out.println(obj.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (!visited[i][j]) {
                        count++;
                        dfs(i, j, grid, visited, dir);
                    }
                }
            }
        }

        return count;
    }

    private void dfs(int x, int y, char[][] grid, boolean[][] visited, int[] dir) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i];
            int nextY = y + dir[i + 1];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                dfs(nextX, nextY, grid, visited, dir);
            }
        }
    }

    public int numIslandsBFS(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (!visited[i][j]) {
                        count++;
                        bfs(i, j, grid, visited);
                    }
                }
            }
        }


        return count;
    }

    private void bfs(int x, int y, char[][] grid, boolean[][] visited) {
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();
        if (visited[x][y]) return;
        q.offer(new Node(x, y));
        while (q.size() > 0) {
            Node node = q.poll();
            visited[node.x][node.y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dir[i];
                int nextY = node.y + dir[i + 1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                    q.offer(new Node(nextX, nextY));
                }
            }
        }
    }

}
