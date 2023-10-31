package leetcode.medium;

import java.util.Arrays;


public class _3SumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 0));
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 1001;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
