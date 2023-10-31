package gfg.amazonprep.contests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] ar = new int[][]{
                {1, 2, 3, 4},
                {2, 2, 3, 4},
                {5, 5, 6, 6},
                {7, 8, 9, 9}
        };
        for (Integer i : mergeKArrays(ar, ar.length)) {
            System.out.print(i + " ");
        }
    }

    static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> PQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        int indexArray[] = new int[k];
        for (int i = 0; i < k; i++) {
            PQ.add(new Pair(i, arr[i][indexArray[i]]));
        }
        int n = k * k;
        while (n-- > 0) {
            Pair p = PQ.poll();
            if (p != null) {
                result.add(p.value);
                indexArray[p.index]++;
                if (indexArray[p.index] < k) {
                    PQ.add(new Pair(p.index, arr[p.index][indexArray[p.index]]));
                }
            }
        }
        return result;
    }
}
