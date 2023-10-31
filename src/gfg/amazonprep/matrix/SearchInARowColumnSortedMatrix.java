package gfg.amazonprep.matrix;

public class SearchInARowColumnSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 30, 38},
                {36, 43, 60},
                {40, 51, 69}
        };
//        int[][] matrix = new int[][]{
//                {1, 2, 2, 2, 3, 5, 7},
//                {9, 10, 13, 15, 15, 16, 19},
//                {19, 21, 21, 23, 23, 26, 26},
//                {27, 29, 29, 31, 31, 33, 34},
//                {35, 35, 35, 36, 36, 36, 37},
//                {38, 40, 41, 44, 45, 45, 48},
//                {48, 51, 52, 53, 53, 57, 57},
//                {58, 59, 59, 59, 61, 63, 64},
//                {65, 67, 68, 69, 70, 70, 70}
//        };
        System.out.print(search(matrix, matrix.length, matrix[0].length, 60));
    }

    static boolean search(int matrix[][], int n, int m, int x) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] == x) {
                return true;
            } else if (matrix[i][m - 1] > x) {
                int j = m - 2;
                while (j >= 0) {
                    if (matrix[i][j] == x) {
                        return true;
                    }
                    j--;
                }
            }
        }
        return false;
    }

//    static boolean bSearch(int matrix[][], int left, int right, int n, int X) {
//        if (left < right) {
//            int mid = left + ((right - left) / 2);
//            int x = mid / n;
//            int y = mid - (x * n);
//            if (matrix[x][y] == X) {
//                return true;
//            } else if (matrix[x][y] < X) {
//                return bSearch(matrix, mid, right, n, X);
//            } else {
//                return bSearch(matrix, left, mid, n, X);
//            }
//        }
//        return false;
//    }
}
