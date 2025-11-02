package leetcode.medium;

import java.util.*;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeArrayEmpty obj = new MinimumNumberOfOperationsToMakeArrayEmpty();
//        System.out.println(obj.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
//        System.out.println(obj.minOperations(new int[]{2, 1, 2, 2, 3, 3}));
        System.out.println(obj.minOperations(new int[]{14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12}));
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (final int num : nums)
            count.merge(num, 1, Integer::sum);

        for (final int freq : count.values()) {
            // If freq == 3k, need k operations.
            // If freq == 3k + 1 = 3*(k - 1) + 2*2, need k + 1 operations.
            // If freq == 3k + 2, need k + 1 operations.
            if (freq == 1)
                return -1;
            ans += (freq + 2) / 3;
        }

        return ans;

    }
    public int minOperations1(int[] nums) {// wrong soln
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int j = i + 1;
            int count = 1;
            while (j < nums.length && x == nums[j]) {
                count++;
                j++;
            }
            if (count % 2 == 0) {
                ans = ans + (count / 2);
            } else if (count % 3 == 0) {
                ans = ans + (count / 3);
            } else {
                return -1;
            }
            i = j - 1;
        }
        return ans;
    }
}
