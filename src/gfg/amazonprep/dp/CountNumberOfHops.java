package gfg.amazonprep.dp;

public class CountNumberOfHops {
    public static void main(String[] args) {
        System.out.println(countWays(1));
        System.out.println(countWays(4));
    }

    public static long countWays(int n) { //DP
        long[] matrix = new long[n + 1];
        return count(n, matrix);
    }

    public static long count(int n, long[] matrix) {
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
        long jump3 = 0L;
        if ((matrix[n - 1] != 0)) {
            jump1 = matrix[n - 1];
        } else {
            jump1 = count(n - 1, matrix) % mod;
            matrix[n - 1] = jump1;
        }

        if ((n - 2) >= 0) {
            if (matrix[n - 2] != 0) {
                jump2 = matrix[n - 2];
            } else {
                matrix[n - 2] = count(n - 2, matrix) % mod;
                matrix[n - 2] = jump2;
            }
        } else {
            return jump1;
        }

        if ((n - 3) >= 0) {
            if (matrix[n - 3] != 0) {
                jump3 = matrix[n - 3];
            } else {
                jump3 = count(n - 3, matrix) % mod;
                matrix[n - 3] = jump3;
            }
        } else {
            return (jump1 + jump2) % mod;
        }
        return (jump1 + jump2 + jump3) % mod;
    }

    public static long countWaysR(int n) { //recursive
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return countWaysR(n - 1) + countWaysR(n - 2) + countWaysR(n - 3);
    }
}
