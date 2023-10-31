package pepcoding.DPandGreedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1Fibonnaci {
    // 0, 1, ,1 ,2, 3, 5, 8, 13, 21, 34, 55,...
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fib(n));
        System.out.println(fibDP(n, new int[n + 1]));
    }

    private static int fib(int n) { // recursive
        if (n == 1 || n == 0) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibDP(int n, int[] dp) { // recursive + Memoization
        if (n == 1 || n == 0) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
}
