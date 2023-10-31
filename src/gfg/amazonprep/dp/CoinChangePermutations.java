package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangePermutations {
    /*
    4
2
3
5
6
7

    Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of permutations and not combinations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
                  combination. You should treat them as 3 and not 1.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        System.out.println(coinPermutations(n, ar, amt));
    }

    private static int coinPermutations(int n, int[] ar, int amt) {
        int[] dp = new int[amt + 1];
        dp[0] = 1; // empty subset
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                int val = ar[j];
                if ((i - val) >= 0) {
                    dp[i] = dp[i] + dp[i - val];
                }
            }
        }
        for (int p : dp) {
            System.out.print(p + " ");
        }
        System.out.print("\n");
        return dp[amt];
    }
}
