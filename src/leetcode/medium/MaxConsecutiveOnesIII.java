package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{1}, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int left = 0;
        int right = 0;
        Queue<Integer> q = new LinkedList<>();
        while (right < n) {
            if (nums[right] == 0) {
                q.offer(right);
            }
            if (q.size() > 0 && q.size() > k) {
                left = q.poll() + 1;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
