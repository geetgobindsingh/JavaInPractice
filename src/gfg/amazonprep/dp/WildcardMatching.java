package gfg.amazonprep.dp;

import java.io.IOException;
import java.util.Scanner;

public class WildcardMatching {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String pattern = sc.nextLine();
        System.out.println(isMatching(input, pattern));
    }

    // same as lcs
    private static boolean isMatching(String input, String pattern) {
        boolean[][] dp = new boolean[pattern.length() + 1][input.length() + 1];
        for (int i = pattern.length(); i >= 0; i--) {
            for (int j = input.length(); j >= 0; j--) {
                if (i == pattern.length()) {
                    dp[i][j] = j == input.length();
                } else if (j == input.length()) {
                    if (pattern.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    switch (pattern.charAt(i)) {
                        case '*': {
                            dp[i][j] =  dp[i + 1][j] ||  dp[i][j + 1];
                            break;
                        }
                        case '?': {
                            dp[i][j] = dp[i + 1][j + 1];
                            break;
                        }
                        default: {
                            if (pattern.charAt(i) == input.charAt(j)) {
                                dp[i][j] = dp[i + 1][j + 1];
                            } else {
                                dp[i][j] = false;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }

}
