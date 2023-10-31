package pepcoding.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnightsTour {

    // https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/knights-tour-official/ojquestion

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int row = Integer.parseInt(br.readLine());
        int col = Integer.parseInt(br.readLine());
        printKnightsTour(new int[n][n], row, col, 1);
    }


    private static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        int n = chess.length;
        if (!safeMove(r, c, n, n) || chess[r][c] > 0) {
            return;
        } else if (upcomingMove == (n * n)) { // base condition
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = upcomingMove;
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);
        chess[r][c] = 0;
    }

    private static boolean safeMove(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    private static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
