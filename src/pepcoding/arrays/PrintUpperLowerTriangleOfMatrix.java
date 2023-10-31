package pepcoding.arrays;

public class PrintUpperLowerTriangleOfMatrix {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printUpperTriangle(matrix);
        printLowerTriangle(matrix);
    }

    private static void printLowerTriangle(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void printUpperTriangle(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < m; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
