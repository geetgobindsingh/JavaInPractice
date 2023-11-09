package leetcode.medium;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(obj.maxSubArray(new int[]{1}));
        System.out.println(obj.maxSubArray(new int[]{-1}));
        System.out.println(obj.maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            max = Math.max(max, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }
}
