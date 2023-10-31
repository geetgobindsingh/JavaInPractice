package gfg.amazonprep.dp;

import java.util.HashMap;
import java.util.Scanner;

public class CountOfDistinctPalindromicSubsequences {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

    public static int solution(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int[] prev = new int[str.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                prev[i] = map.get(str.charAt(i));
            } else {
                prev[i] = -1;
            }
            map.put(str.charAt(i), i);
        }
        map.clear();

        int[] next = new int[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            if (map.containsKey(str.charAt(i))) {
                next[i] = map.get(str.charAt(i));
            } else {
                next[i] = -1;
            }
            map.put(str.charAt(i), i);
        }


        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < str.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    dp[i][j] = 2;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        int nextIndex = next[i];
                        int prevIndex = prev[j];
                        if (nextIndex > prevIndex) {
                            dp[i][j] = (2 * dp[i + 1][j - 1]) + 2;
                        } else if (nextIndex == prevIndex) {
                            dp[i][j] = (2 * dp[i + 1][j - 1]) + 1;
                        } else {
                            dp[i][j] = (2 * dp[i + 1][j - 1]) - dp[nextIndex + 1][prevIndex - 1];
                        }
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        return dp[0][str.length() - 1];
    }

}
