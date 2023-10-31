package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetSumSubsets {
    /*
    5
    4
    2
    7
    1
    3
    10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        int tar = Integer.parseInt(br.readLine());
        System.out.println(isTargetSubSubSetAvailable(n, ar, tar));
    }

    public static boolean isTargetSubSubSetAvailable(int n, int[] ar, int tar) {
        boolean[][] dp = new boolean[n + 1][tar + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                if (j == 0 && i == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j]) { // if not itself
                        dp[i][j] = true;
                    } else { //it self
                        int val = ar[i - 1]; // -1 because of extra size due to empty set at beginning
                        dp[i][j] = ((j - val>=0) && dp[i - 1][j - val]);
                    }
                }
            }
        }
        return dp[n][tar];
    }
}
