package gfg.amazonprep.dp;

import java.util.HashSet;
import java.util.Set;

public class CountWaysToNthStair_OrderDoesNotMatter {
    public static void main(String[] args) {
        System.out.print(countWays(4));
    }

    static Long countWays(int n) {
        if (n == 2) return 2L;
        if (n == 1) return 1L;
        long[] matrix = new long[n];
        Set<String> patterns = new HashSet<>();
        long result = count(n - 1, matrix, 0, "", patterns);
        for (String s : patterns) {
            System.out.print(s + " ");
        }
        return result;
    }

    public static long count(int n, long[] matrix, int min, String jump, Set<String> patterns) {
        if (n < min) {
            
            return 0;
        }
        if (n < 0) {

            return 0;
        }
        if (n == 0 || n == 1) {

            return 1;
        }
        matrix[0] = 1;
        matrix[1] = 1;
        int mod = 1000000007;
        long jump1 = 0L;
        long jump2 = 0L;

        if ((matrix[n - 1] != 0)) {
            jump1 = matrix[n - 1];
        } else {
            jump1 = count(n - 1, matrix, 1, jump + "1", patterns) % mod;
            matrix[n - 1] = jump1;
        }

        if ((n - 2) >= 0) {
            if (matrix[n - 2] != 0) {
                jump2 = matrix[n - 2];
            } else {
                matrix[n - 2] = count(n - 2, matrix, 2, jump + "2", patterns) % mod;
                matrix[n - 2] = jump2;
            }
        } else {

            return jump1;
        }

        return (jump1 + jump2) % mod;
    }
}
