package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion#
//TODO: @Interesting
public class FriendsPairing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(numberOfWaySingleOrPairing(n));
    }

    // Same as fibonacci
    private static long numberOfWaySingleOrPairing(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 2] * (i - 1));
        }
        return dp[n];
    }
}
