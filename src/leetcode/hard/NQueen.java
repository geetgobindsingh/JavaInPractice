package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        for (List<String> list : solveNQueens(4)) {
            System.out.print("[");
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList();
        int[][] chess = new int[n][n];
        List<String> qsf = new ArrayList();
        traverseChess(chess, 0, n, result, qsf);
        return result;
    }

    public static void traverseChess(
            int[][] chess,
            int r, int n,
            List<List<String>> result,
            List<String> qsf
    ) {
        if (r == n) {
            result.add(new ArrayList<>(qsf));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafeMove(chess, r, i, n)) {
                chess[r][i] = 1;
                String move = getMove(i, n);
                qsf.add(move);
                traverseChess(chess, r + 1, n, result, qsf);
                chess[r][i] = 0;
                qsf.remove(move);
            }
        }

    }

    public static boolean isSafeMove(int[][] chess, int r, int c, int n) {
        if (r < 0 || c < 0 || r == n || c == n || chess[r][c] == 1) {
            return false;
        }
        for (int i = r - 1, j = c; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static String getMove(int c, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            if (i == c) {
                result = result + "Q";
            } else {
                result = result + ".";
            }
        }
        return result;
    }
}
