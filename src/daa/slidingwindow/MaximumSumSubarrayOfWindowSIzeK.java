package daa.slidingwindow;

public class MaximumSumSubarrayOfWindowSIzeK {
    public static void main(String[] args) {
        MaximumSumSubarrayOfWindowSIzeK obj = new MaximumSumSubarrayOfWindowSIzeK();
        System.out.println(obj.maxSum(new int[]{1,3,2,4,5,6}, 3));
        System.out.println(obj.maxSum(new int[]{1,5,4,2,9,9,9}, 3));
    }

    private int maxSum(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            int windowSize = right - left + 1;
            sum = sum + nums[right];
            if (windowSize == k) {
                max = Math.max(max, sum);
                sum = sum - nums[left++];
            }
        }
        return max;
    }


}
