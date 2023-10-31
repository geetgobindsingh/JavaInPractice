package leetcode.hard;

import java.util.*;

public class ConstrainedSubsequenceSum { // imp
    public static void main(String[] args) {
        ConstrainedSubsequenceSum obj = new ConstrainedSubsequenceSum();
        System.out.println(obj.constrainedSubsetSum3(new int[]{10, 2, -10, 5, 20}, 2)); //37 // j-i<=k
        System.out.println(obj.constrainedSubsetSum(new int[]{-1,-2,-3}, 1));
        System.out.println(obj.constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
        System.out.println(obj.constrainedSubsetSum(new int[]{-5266, 4019, 7336, -3681, -5767}, 2)); //11355 // j-i<=k
    }

    public int constrainedSubsetSum(int[] nums, int k) { // T(O(N)) S(O(K))
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] += !dq.isEmpty() ? nums[dq.peekFirst()] : 0;

            while (!dq.isEmpty() && (i - dq.peekFirst() >= k || nums[i] >= nums[dq.peekLast()])) {
                if (nums[i] >= nums[dq.peekLast()]) dq.pollLast();
                else dq.pollFirst();
            }

            if (nums[i] > 0) {
                dq.offerLast(i);
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
    public int constrainedSubsetSum3(int[] nums, int k) { // T(O(N)) S(O(N))
        int n = nums.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (!q.isEmpty() && i - q.peek() > k) {
                q.pollFirst();
            }
            dp[i] = Math.max(0, q.isEmpty() ? 0 : dp[q.peekFirst()]) + nums[i];
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int constrainedSubsetSum2(int[] nums, int k) { // still TLE but correct solution
        int n = nums.length;
        int[] dp = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        dp[0] = nums[0];
        int max = dp[0];
        pq.offer(max);
        for (int j = 1; j < n; ++j) {
            if (pq.peek() >= 0) {
                dp[j] = nums[j] + pq.peek();
            } else {
                dp[j] = nums[j];
            }
            max = Math.max(max, dp[j]);
            if (pq.size() == k && (j - k) >= 0) {
                pq.remove(dp[j - k]);
            }
            pq.offer(dp[j]);
        }
        return max;
    }

    public int constrainedSubsetSum1(int[] nums, int k) { // correct solution but TLE
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int j = 1; j < n; ++j) {
            int m = 0;
            for (int i = j - 1; i >= j - k && i >= 0; --i) {
                m = Math.max(m, dp[i]);
            }
            dp[j] = nums[j] + m;
            max = Math.max(max, dp[j]);
        }
        return max;
    }
}
