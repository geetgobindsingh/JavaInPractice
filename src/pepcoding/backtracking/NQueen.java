package pepcoding.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printNQueens(new int[n][n], "", 0);
    }

    private static void printNQueens(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf);
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            if (isSafeMove(chess, row, i)) {
                chess[row][i] = 1;
                printNQueens(chess, qsf + row + "-" + i + ", ", row + 1);
                chess[row][i] = 0;
            }
        }
    }

    private static boolean isSafeMove(int[][] chess, int row, int col) {
        if (chess[row][col] == 0) {
            int n = chess.length;
            // need not check horizontal because we are adding for row first time
//            // check horizontal
//            for (int i = 0; i < n; i++) {
//                if (chess[row][i] == 1) {
//                    return false;
//                }
//            }

            // check vertical that too upwards only
            for (int i = row - 1, j = col; i >= 0; --i) {
                if (chess[i][j] == 1) {
                    return false;
                }
            }
            // check left diagonal upward
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chess[i][j] == 1) {
                    return false;
                }
            }
            // check right diagonal upward
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (chess[i][j] == 1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
