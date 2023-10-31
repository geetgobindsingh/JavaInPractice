package gfg.amazonprep.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-encodings-official/ojquestion
public class CountEncodings {

    // @Difficult
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.print(countOfEncodings(input));
    }

    /*
    in: 123
    out: 3 [abc, aw, lc]
     */
    private static int countOfEncodings(String input) {
        int[] dp = new int[input.length()];
        dp[0] = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == '0'
                    && input.charAt(i) == '0') {
                dp[i] = 0;
            } else if (input.charAt(i - 1) == '0'
                    && input.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else if (input.charAt(i - 1) != '0'
                    && input.charAt(i) == '0') {
                if (input.charAt(i - 1) != '1' || input.charAt(i - 1) != '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else {
                if (Integer.parseInt(input.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[input.length() - 1];
    }

}
