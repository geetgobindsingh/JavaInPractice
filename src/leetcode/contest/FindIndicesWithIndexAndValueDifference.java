package leetcode.contest;

import java.util.Arrays;
import java.util.Comparator;

public class FindIndicesWithIndexAndValueDifference {
    public static void main(String[] args) {
        FindIndicesWithIndexAndValueDifference obj = new FindIndicesWithIndexAndValueDifference();
        for (int i : obj.findIndices(new int[]{5, 1, 4, 1}, 2, 4)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i : obj.findIndices(new int[]{2, 1}, 0, 0)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i : obj.findIndices(new int[]{1, 2, 3}, 2, 4)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    static class Pair {
        int x;
        int op;

        public Pair(int x, int op) {
            this.x = x;
            this.op = op;
        }
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        Pair[] ar = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ar[i] = new Pair(nums[i], i);
        }
        Arrays.sort(ar, Comparator.comparingInt(o -> o.x));

        for (int i = 0; i < (ar.length); ++i) {
            for (int j = i; j < ar.length; ++j) {
                if (Math.abs(ar[i].op - ar[j].op) >= indexDifference && Math.abs(ar[i].x - ar[j].x) >= valueDifference) {
                    if (ar[i].op < ar[j].op) {
                        return new int[]{ar[i].op, ar[j].op};
                    } else {
                        return new int[]{ar[j].op, ar[i].op};
                    }

                }
            }
        }
        return new int[]{-1, -1};
    }
}
