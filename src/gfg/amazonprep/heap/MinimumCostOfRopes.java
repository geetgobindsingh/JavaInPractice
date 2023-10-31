package gfg.amazonprep.heap;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long[] ar = new long[]{4, 3, 2, 6};
        System.out.print(minCost(ar, ar.length));
    }

    public static long minCost(long arr[], int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return arr[0] + arr[1];
        }
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long i : arr) {
            minHeap.add(i);
        }
        long cost = 0;
        while (!minHeap.isEmpty()) {
            Long a = minHeap.poll();
            Long b = minHeap.poll();
            long sum = a + b;
            if (!minHeap.isEmpty()) {
                minHeap.add(sum);
            }
            cost = cost + sum;
        }
        return cost;
    }
}
