package gfg.amazonprep.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        for (int i : obj.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int iter = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int left = 0, right = 0; right < n; right++) {
            while (q.size() > 0 && nums[q.peekLast()] < nums[right]) {
                q.pollLast();
            }
            q.offerLast(right);
            if ((right - left + 1) == k) {
                result[iter++] = nums[q.peekFirst()];
                if (left == q.peekFirst()) {
                    q.pollFirst();
                }
                left++;
            }
        }
        return result;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0, j = 0; i < n; ++i) {
            if (!q.isEmpty() && i - k + 1 > q.peekFirst()) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                ans[j++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
    public int[] maxSlidingWindow1(int[] nums, int k) { //tle
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int iter = 0;
        int nextMax = 0;
        for (int left = 0, right = 0; right < n; right++) {
            nextMax = Math.max(nextMax, nums[right]);
            if ((right - left + 1) == k) {
                result[iter++] = nextMax;
                nextMax = Integer.MIN_VALUE;
                left++;
                for (int i = left; i <= right && i < n; i++) {
                    nextMax = Math.max(nextMax, nums[i]);
                }
            }
        }
        return result;
    }

}
