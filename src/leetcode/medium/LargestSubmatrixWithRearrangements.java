package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSubmatrixWithRearrangements {

    public static void main(String[] args) {
        LargestSubmatrixWithRearrangements obj = new LargestSubmatrixWithRearrangements();
        System.out.println(obj.largestSubmatrix(new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1},
        }));
//        System.out.println(obj.largestSubmatrix(new int[][]{
//                {1, 0, 1, 0, 1},
//        }));
//        System.out.println(obj.largestSubmatrix(new int[][]{
//                {1, 1, 0},
//                {1, 0, 1},
//        }));
    }

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        int ans = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
            }
        }
        return ans;

    }
    public int largestSubmatrix1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newMatrix = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][i] = matrix[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        return -1;
    }
}
