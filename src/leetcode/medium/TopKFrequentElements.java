package leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        for (int i : obj.topKFrequent(new int[]{1,1,1,2,2,3}, 2)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    static class Pair implements Comparable<Pair>{
        final Integer val;
        final Integer count;
        public Pair(Integer val, Integer count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(count, o.count);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int[] result = new int[k];
        for (int i = 0; i < k ; i++) {
            result[i] = pq.poll().val;
        }
        return result;
    }
}
