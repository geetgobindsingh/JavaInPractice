package gfg.amazonprep.dp;

import java.util.Scanner;

public class CountPallindromicSubSequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(countPalindromes(a));
    }

    private static int countPalindromes(String a) {
        boolean[][] dp = new boolean[a.length()][a.length()];
        int counter = 0;
        for (int gap = 0; gap < a.length(); gap++) {
            for (int i = 0, j = gap; j < a.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = a.charAt(i) == a.charAt(j);
                } else {
                    dp[i][j] = a.charAt(i) == a.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] ) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
