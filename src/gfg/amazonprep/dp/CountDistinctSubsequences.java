package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountDistinctSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        System.out.println(countDistinctSubSequences(a));
    }

    private static long countDistinctSubSequences(String a) {
        if (a.length() == 0) return 0;
        long[] dp = new long[a.length() + 1];
        dp[0] = 1; // empty have 1 subsequence which is itself
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i <= a.length(); i++) {
            Character ch = a.charAt(i - 1);

            dp[i] = 2 * dp[i - 1];

            if (map.containsKey(ch)) {
                dp[i] = dp[i] - dp[map.get(ch) - 1];
            }
            map.put(ch, i);
        }
        return dp[a.length()] - 1;
    }
}
