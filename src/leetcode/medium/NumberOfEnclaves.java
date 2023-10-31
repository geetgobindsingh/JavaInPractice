package leetcode.medium;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        NumberOfEnclaves obj = new NumberOfEnclaves();
        int[][] grid = new int[][] {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        obj.displayArray(grid);
        System.out.print(obj.numEnclaves(grid));
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
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 || j == 0 || i == (m - 1) || j == (n - 1))
                        && grid[i][j] == 1) {
                    dfs(grid, i , j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
