package leetcode.medium;

public class LongestNiceSubarray {
    public static void main(String[] args) {
        LongestNiceSubarray obj = new LongestNiceSubarray();
        System.out.println(obj.longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
    }

    public int longestNiceSubarray(int[] nums) {
        int max = 0, mask = 0;
        for (int left = 0, right = 0; right < nums.length; ++right) {
            while ((mask & nums[right]) != 0) {
                mask = mask ^ nums[left++];
            }
            max = Math.max(max, right - left + 1);
            mask = mask | nums[right];
        }
        return max;
    }
}
