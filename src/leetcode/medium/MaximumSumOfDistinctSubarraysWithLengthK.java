package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        MaximumSumOfDistinctSubarraysWithLengthK obj = new MaximumSumOfDistinctSubarraysWithLengthK();
        System.out.println(obj.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
        System.out.println(obj.maximumSubarraySum(new int[]{4,4,4}, 3));
        System.out.println(obj.maximumSubarraySum(new int[]{5,3,3,1,1}, 3));
        System.out.println(obj.maximumSubarraySum(new int[]{3,2,3,1}, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long max = 0;
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int left = 0, right = 0; right < n; right++) {
            if (set.size() < k) {
                while (set.contains(nums[right])) {
                    sum = sum - nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                set.add(nums[right]);
                sum = sum + nums[right];
            }
            if (set.size() == k) {
                max = Math.max(max, sum);
                sum = sum - nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        return max;
    }
    public long maximumSubarraySum1(int[] nums, int k) {
        int n = nums.length;
        long max = 0;
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int left = 0, right = 0; right < n; right++) {
            int windowSize = right - left + 1;
            if (set.contains(nums[right])) {
                if (set.contains(nums[left])) {
                    sum = sum - nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                continue;
            }
            if (windowSize < k && !set.contains(nums[right])) {
                set.add(nums[right]);
                sum = sum + nums[right];
            }
            if (windowSize == k) {
                max = Math.max(max, sum);
                if (set.contains(nums[left])) {
                    sum = sum - nums[left];
                    set.remove(nums[left]);
                    left++;
                }
            }
        }
        return max;
    }
}
