package leetcode.medium;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrixFastest(new int[][]{{1, 3, 4, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(searchMatrixBinarySearch(new int[][]{{1}, {10}}, 3));
    }

    public static boolean searchMatrixFastest(int[][] a, int target) {
        int n = a.length;
        int m = a[0].length;
        int p1 = 0, p2 = m - 1;
        while (p1 < n && p2 >= 0) {
            if (a[p1][p2] == target) {
                return true;
            } else if (a[p1][p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return false;
    }

    public static boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int leftRow = 0;
        int rightRow = m - 1;
        while (leftRow < rightRow) {
            int mid = (leftRow + rightRow) >> 1;
            if (matrix[mid][n - 1] < target) {
                leftRow = mid + 1;
            } else {
                rightRow = mid;
            }
        }
        int leftCol = 0;
        int rightCol = n - 1;
        while (leftCol < rightCol) {
            int mid = (leftCol + rightCol) >> 1;
            if (matrix[rightRow][mid] < target) {
                leftCol = mid + 1;
            } else {
                rightCol = mid;
            }
        }
        return matrix[rightRow][rightCol] == target;
    }
}
