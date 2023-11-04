package leetcode.medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
