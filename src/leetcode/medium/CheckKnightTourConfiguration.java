package leetcode.medium;

public class CheckKnightTourConfiguration {
    public static void main(String[] args) {
        int[][] ar = new int[][]{
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };

        System.out.println(checkValidGrid(ar));

        ar = new int[][]{
                {0, 3, 6}, {5, 8, 1}, {2, 7, 4}
        };

        System.out.println(checkValidGrid(ar));
    }

    public static boolean checkValidGrid(int[][] grid) {
        return check(grid, 0, 0, 0);
    }

    public static boolean check(int[][] grid, int r, int c, int moves) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length) {
            return false;
        }
        if (grid[r][c] != moves) {
            return false;
        }
        if (grid[r][c] == moves && moves == ((grid.length * grid.length) - 1)) {
            return true;
        }

        boolean step1 = check(grid, r - 2, c + 1, moves + 1);
        boolean step2 = check(grid, r - 1, c + 2, moves + 1);
        boolean step3 = check(grid, r + 1, c + 2, moves + 1);
        boolean step4 = check(grid, r + 2, c + 1, moves + 1);
        boolean step5 = check(grid, r + 2, c - 1, moves + 1);
        boolean step6 = check(grid, r + 1, c - 2, moves + 1);
        boolean step7 = check(grid, r - 1, c - 2, moves + 1);
        boolean step8 = check(grid, r - 2, c - 1, moves + 1);

        if (step1 || step2 || step3 || step4 || step5 || step6 || step7 || step8) {
            return true;
        }
        return false;
    }
}
