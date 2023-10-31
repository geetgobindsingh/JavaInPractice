package gfg.amazonprep.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {16, 28, 60, 64},
                {22, 41, 63, 91},
                {27, 50, 87, 93},
                {36, 78, 87, 94}
        };
//        System.out.println(kthSmallest(matrix, matrix.length, 3));
        System.out.println(kthSmallest(matrix, matrix.length, 4));
    }

    public static int kthSmallest(int[][] mat, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int j = 0;
        int K = 0;
        minHeap.add(mat[i][j]);
        if (k == 0) {
            return minHeap.poll();
        }
        while (K != k) {
            int bottom = mat[i+1][j];
            int right = mat[i][j+1];
            if (bottom < right) {
                minHeap.add(bottom);
                i++;
            } else {
                minHeap.add(right);
                j++;
            }
            K++;
        }
        return minHeap.poll() != null ? minHeap.poll() : -1;
    }
}
