package gfg.amazonprep.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (Integer i : mergeKArrays(arr, arr.length)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) { // O(nlogn)
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            for (int j : arrays[i]) {
                heap.add(j);
            }
        }

        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }
}
