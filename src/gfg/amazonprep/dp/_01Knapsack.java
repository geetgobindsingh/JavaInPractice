package gfg.amazonprep.dp;

public class _01Knapsack {
    public static void main(String[] args) {
        int W = 4;
        int n = 3;
        int[] val = new int[]{3, 1, 2};
        int[] wt = new int[]{1, 4, 5};
        System.out.print(knapSack(W, wt, val, n));
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int matrix[][] = new int[n + 1][W + 1];
        for (int i = 0; i < (W + 1); i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i < (n + 1); i++) {
            matrix[i][0] = 0;
        }
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (W + 1); j++) {
                if (j >= wt[i - 1]) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], val[i - 1] + matrix[i - 1][j - wt[i - 1]]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
//        for (int i = 0; i < (n + 1); i++) {
//            for (int j = 0; j < (W + 1); j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
        return matrix[n][W];
    }
}
