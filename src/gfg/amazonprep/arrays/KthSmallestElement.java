package gfg.amazonprep.arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {
    /*
    7 10 4 3 20 15
    k = 3
    Ans: 7
     */
    public static void main(String[] args) throws IOException {
        System.out.println(getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 3));
        System.out.println(getKthSmallestElementFromMinHeap(new int[]{7, 10, 4, 3, 20, 15}, 3));
    }

    private static int getKthSmallestElement(int[] input, int k) {
        Arrays.sort(input);
        return input[k - 1];
    }

    private static int getKthSmallestElementFromMinHeap(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : input) {
            pq.offer(i);
        }
        int result = -1;
        for (int i = 0; i < k; i++) {
            result = pq.remove();
        }
        return result;
    }

    private static int getKthSmallestElementFromQuickSelect(int[] input, int k) {

        return input[k - 1];
    }

    private static int partition(int[] input, int l, int r) {
        return 1;
    }
}
