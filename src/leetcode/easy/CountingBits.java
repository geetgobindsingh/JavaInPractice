package leetcode.easy;

public class CountingBits {
    public static void main(String[] args) {
        CountingBits obj = new CountingBits();
        for (int i : obj.countBits(2)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

}
