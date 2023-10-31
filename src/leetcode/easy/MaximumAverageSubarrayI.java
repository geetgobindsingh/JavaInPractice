package leetcode.easy;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) { // O(N)
        double max = -Double.MAX_VALUE;
        double average;
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        average = sum / k;
        max = Math.max(max, average);
        for (int i = k; i < (nums.length); ++i) {
            sum = (sum - nums[i - k]) + nums[i];
            average = (sum / k);
            max = Math.max(max, average);
        }
        return max;
    }

    public static double findMaxAverage2(int[] nums, int k) { // O(N^2)
        double max = -Double.MAX_VALUE;
        for (int i = 0; i < (nums.length - k + 1); ++i) {
            double average = 0.0;
            for (int j = k + i - 1; j >= i; --j) {
                average = average + nums[j];
            }
            average = average / k;
            max = Math.max(max, average);
        }
        return max;
    }

}
