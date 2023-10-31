package leetcode.medium;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        System.out.println(String.valueOf(22674794l * 422674794l));
        System.out.println(new Solution().judgeSquareSum(2147483636));
        System.out.println(new Solution().bruteForce(2147483636));
        //System.out.println(new Solution().judgeSquareSum(2147483600));
    }

    static class Solution {

        public boolean bruteForce(int c) {
            int k = (int) Math.ceil(Math.sqrt(c));
            for (long i = 0; i <= k; i++) {
                for (long j = 0; j <= k; j++) {
                    long low = i * i;
                    long high = j * j;
                    long sum = low + high;
                    if (sum == c) {
                        System.out.println(i + " square is " + low);
                        System.out.println(j + " square is " + high);
                        System.out.println("sum is" + " " + sum);
                        System.out.println("OG  is" + " " + c);
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean judgeSquareSum(int c) {
            if (c == 0 || c == 1) {
                return true;
            }
            int i = 0;
            long j = (int) Math.ceil(Math.sqrt(c));
            while (i <= j) {
                int low = i * i;
                long high = j * j;
                long sum = low + high;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
}
