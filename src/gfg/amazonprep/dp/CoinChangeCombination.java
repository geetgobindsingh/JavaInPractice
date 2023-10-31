package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeCombination {
    /*
    4
2
3
5
6
7

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of combinations and not permutations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
                  combination. You should treat them as 1 and not 3.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        System.out.println(coinCombinations(n, ar, amt));
    }

    private static int coinCombinations(int n, int[] ar, int amt) {
        int[] dp = new int[amt + 1];
        dp[0] = 1; // empty subset
        for (int i = 0; i < ar.length; i++) {
            for (int j = ar[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - ar[i]];
            }
        }
        System.out.print("\n");
        return dp[amt];
    }



}
