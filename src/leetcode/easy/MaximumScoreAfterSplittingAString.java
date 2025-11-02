package leetcode.easy;

public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        MaximumScoreAfterSplittingAString obj = new MaximumScoreAfterSplittingAString();
        System.out.println(obj.maxScore("011101"));
        System.out.println(obj.maxScore("1111"));
        System.out.println(obj.maxScore("0000"));
    }

    public int maxScore(String s) {
        int ans = 0;
        int zeros = 0;
        int ones = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        for (int i = 0; i + 1 < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++zeros;
            } else {
                --ones;
            }
            ans = Math.max(ans, zeros + ones);
        }

        return ans;
    }
    public int maxScore1(String s) {//wrong soln
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];
        int zCount = 0;
        int oCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zCount++;
            }
            zeros[i] = zCount;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1') {
                oCount++;
            }
            ones[i] = oCount;
        }
        int ans = 0;
        int maxO = zeros[ans];
        int max1 = ones[ans];
        for (int i = 1; i < s.length(); i++) {
            if (zeros[i] >= maxO && ones[i] >= max1) {
                ans = 1;
                maxO = zeros[ans];
                max1 = ones[ans];
            }
        }
        return maxO + max1;
    }
}
