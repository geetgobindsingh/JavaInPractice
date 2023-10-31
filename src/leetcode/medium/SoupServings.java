package leetcode.medium;

import java.util.HashMap;
import java.util.Objects;

public class SoupServings {

    public static void main(String[] args) {
        System.out.println(soupServings(50));
        System.out.println(soupServings(100));
        System.out.println(soupServings(660295675));
        System.out.println(new Integer((int) 1000_000_000_000l));
        System.out.println(findingOptimalSize(1000_000_000));
    }

    /*
    Approach
    From Hint-1 and given 4 operation we can easily say that probability of A to get empty is always greater than B to get empty.
    From Hint-2 we can say that probability greater than 0.999995 is treated as 1.
    So from Hint-1 and Hint-2 we know we have to find N which have probabilty 0.999995.
    Now If we observe time complexity of dp approach is almost O(N^2) and we need new n which is sqrt(10^9) approx 10^4.
    Now we can further optimze the N to get probability = 0.999995 which is N=4800.
    But its not intutive to get N=4800 in interview.
    But if interviewer ask for smallest N where probability is 1 then we can do a binary search to find it.
    Key points to solve problem is to understand that
    Probability of A is increasing as N increase and it will become 1 for large N.
    We have to reduce value of N until we get p=0.999995 or N where our solution works fine.
    Complexity
    Time complexity:O(N*N) where 10^4
    Space complexity:O(N*N) where N = 10^4
     */
    public static double soupServings(long n) {
        n = Math.min(n, Integer.MAX_VALUE);
        int m = (int) (n / 25); //maxArrayLength
        HashMap<Dp, Double> dp = new HashMap<>();
        return n > 10000 ? 1 : soupServingsDp(m, m, dp);
    }

    public static double soupServingsDp(int A, int B, HashMap<Dp, Double> dp) {
        // base
        if (B == 0 && A > 0) {
            return 0;
        }
        if (B == 0 && A == 0) {
            return 0.5;
        }
        if (A == 0 && B > 0) {
            return 1;
        }
        Dp dpee = new Dp(A, B);
        if (dp.containsKey(dpee)) {
            return dp.get(dpee);
        }


        double op1 = (0.25) * soupServingsDp(get(A - 4), get(B), dp);
        double op2 = (0.25) * soupServingsDp(get(A - 3), get(B - 1), dp);
        double op3 = (0.25) * soupServingsDp(get(A - 2), get(B - 2), dp);
        double op4 = (0.25) * soupServingsDp(get(A - 1), get(B - 3), dp);
        double total = op1 + op2 + op3 + op4;

        dp.put(dpee, total);

        return dp.get(dpee);
    }

    public static int get(int subtract) {
        return Math.max(subtract, 0);
    }

    public static long findingOptimalSize(long maxN) {
        long l = 1;
        long r = maxN;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (soupServings(mid) > (-1 * (10e-6 - 1))) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static class Dp {
        int a;
        int b;

        Dp(int a, int b) {
            this.a = a;
            this.b = b;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dp dp = (Dp) o;
            return a == dp.a && b == dp.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
