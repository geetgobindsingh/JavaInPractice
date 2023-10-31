package leetcode.hard;

import java.util.HashMap;

public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeArrayContinuous obj = new MinimumNumberOfOperationsToMakeArrayContinuous();
        System.out.println(obj.minOperations(new int[]{1, 10, 100, 1000}));
        System.out.println(obj.minOperations(new int[]{1, 2, 3, 5, 6}));
        System.out.println(obj.minOperations(new int[]{4, 2, 5, 3}));
        System.out.println(obj.minOperations(new int[]{8, 5, 9, 9, 8, 4}));
        System.out.println(obj.minOperations(new int[]{41, 33, 29, 33, 35, 26, 47, 24, 18, 28}));
    }

    public int minOperations(int[] nums) {
        int min = 1000_000_000;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            min = Math.min(min, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = nums.length + min - 1;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                count++;
            }
            if (map.get(nums[i]) > 1) {
                count = count + map.get(nums[i]) - 1;
                map.put(nums[i], 1);
            }
        }
        return count;
    }
}
