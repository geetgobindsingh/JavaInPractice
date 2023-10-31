package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int stairs[] = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(numberOfDiffPaths(n, 0, stairs));
        System.out.println(numberOfDiffPaths1(n, stairs));
    }

    private static int numberOfDiffPaths1(int n, int[] stairs) {
        int dp[] = new int[n + 1];
        dp[stairs.length] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= stairs[i]; j++) {
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }

    // Wrong answer
    public static int numberOfDiffPaths(int n, int index, int stairs[]) {
        if (index == (n - 1)) {
            return 1;
        }
        if (index >= n) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= stairs[index]; i++) {
            sum += numberOfDiffPaths(n, (index + i), stairs);
        }
        return sum;
    }

}
