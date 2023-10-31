package gfg.amazonprep.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        System.out.print(rotOranges(a, 3, 5));
    }

    public static int rotOranges(int a[][], int r, int c) {
        // Write your code here
        Set<Integer> fresh = new HashSet<>();
        Queue<Integer> oldRottens = new LinkedList<>();
        Queue<Integer> newRottens = new LinkedList<>();
        for (int index_i = 0; index_i < r; index_i++) {
            for (int index_j = 0; index_j < c; index_j++) {
                if (a[index_i][index_j] == 1) {
                    fresh.add(index_i * c + index_j);
                }
                if (a[index_i][index_j] == 2) {
                    oldRottens.add(index_i * c + index_j);
                }
            }
        }
        boolean done = false;
        int count = 0;
        while (!done) {
            while (!oldRottens.isEmpty()) {
                int i = oldRottens.poll();
                int x = i / c;
                int y = i % c;
                // Left
                int left = (y == 0) ? -1 : (x * c) + (y - 1);
                if (fresh.contains(left)) {
                    newRottens.add(left);
                    fresh.remove(left);
                }
                // Right
                int right = (y == (c - 1)) ? -1 : (x * c) + (y + 1);
                if (fresh.contains(right)) {
                    newRottens.add(right);
                    fresh.remove(right);
                }
                // Top
                int top = (x == 0) ? -1 : ((x - 1) * c) + y;
                if (fresh.contains(top)) {
                    newRottens.add(top);
                    fresh.remove(top);
                }
                // Bottom
                int bottom = (x == (r - 1)) ? -1 : ((x + 1) * c) + y;
                if (fresh.contains(bottom)) {
                    newRottens.add(bottom);
                    fresh.remove(bottom);
                }
            }
            if (newRottens.isEmpty()) {
                done = true;
            } else {
                count++;
                oldRottens = newRottens;
                newRottens = new LinkedList<>();
            }
        }
        if (fresh.isEmpty()) {
            return count;
        }
        return -1;
    }
}
