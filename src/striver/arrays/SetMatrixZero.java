package striver.arrays;

public class SetMatrixZero {
    //https://takeuforward.org/data-structure/set-matrix-zero/

    public static void main(String[] args) {
        int[][] ar = new int[][]{{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {0, 0, 0, 1}};
        printMatrix(ar);
        setMatrixZeroBruteForce(ar);
        printMatrix(ar);
        ar = new int[][]{{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {0, 0, 0, 1}};
        setMatrixZeroBetter(ar);
        printMatrix(ar);
        ar = new int[][]{{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {0, 0, 0, 1}};
        setMatrixZeroBest(ar);
        printMatrix(ar);
    }

    private static void printMatrix(int[][] ar) {
        int rows = ar.length;
        int columns= ar[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(ar[i][j] + " ,");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void setMatrixZeroBruteForce(int[][] ar) {
        int rows = ar.length;
        int columns= ar[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // make all row brother -1 if not -1 or 0
                if (ar[i][j] == 0) {
                    for (int ii = 0; ii < rows; ii++) {
                        ar[i][ii] = -1;
                    }
                    for (int ii = 0; ii < columns; ii++) {
                        ar[ii][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (ar[i][j] == -1) {
                    ar[i][j] = 0;
                }
            }
        }
    }

    private static void setMatrixZeroBetter(int[][] ar) {
        int rows = ar.length;
        int columns= ar[0].length;
        int a[] = new int[rows];
        for (int i = 0; i < rows; i++) {
            a[i] = 1;
        }
        int b[] = new int[columns];
        for (int i = 0; i < columns; i++) {
            b[i] = 1;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (ar[i][j] == 0) {
                    a[i] = 0;
                    b[j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i] == 0 || b[j] == 0) {
                    ar[i][j] = 0;
                }
            }
        }
    }

    private static void setMatrixZeroBest(int[][] ar) {
        int rows = ar.length;
        int columns= ar[0].length;
        boolean column = true;
        for (int i = 0; i < rows; i++) {
            if (ar[i][0] == 0) {
                column = false;
            }
            for (int j = 1; j < columns; j++) { // note j = 1
                if (ar[i][j] == 0) {
                    ar[i][0] = 0;
                    ar[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                if (ar[i][0] == 0 || ar[0][j] == 0) {
                    ar[i][j] = 0;
                }
            }
            if (!column) {
                ar[i][0] = 0;
            }
        }
    }
}
