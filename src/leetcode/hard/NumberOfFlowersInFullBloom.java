package leetcode.hard;

import java.util.*;

public class NumberOfFlowersInFullBloom {
    public static void main(String[] args) {
        NumberOfFlowersInFullBloom obj = new NumberOfFlowersInFullBloom();
        for (int i : obj.fullBloomFlowers(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11})) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : obj.fullBloomFlowers(new int[][]{{1, 10}, {3, 3}}, new int[]{3, 3, 2})) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (int[] flower : flowers) {
            starts.add(flower[0]);
            ends.add(flower[1]);
        }

        Collections.sort(starts);
        Collections.sort(ends);

        for (int i = 0; i < people.length; ++i) {
            final int started = firstGreater(starts, people[i]);
            final int ended = firstGreaterEqual(ends, people[i]);
            ans[i] = started - ended;
        }

        return ans;
    }

    // Finds the first index l s.t A.get(l) > target.
    // Returns A.size() if can't find.
    private int firstGreater(List<Integer> A, int target) {
        int l = 0;
        int r = A.size();
        while (l < r) {
            final int m = (l + r) / 2;
            if (A.get(m) > target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    // Find the first index l s.t A.get(l) >= target
    // Returns A.size() if can't find
    private int firstGreaterEqual(List<Integer> A, int target) {
        int l = 0;
        int r = A.size();
        while (l < r) {
            final int m = (l + r) / 2;
            if (A.get(m) >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public int[] fullBloomFlowers2(int[][] flowers, int[] people) { // Memory Limit Exceeded // T = O(f + p), S = O(Time)
        int[] result = new int[people.length];

        int maxTime = 0;
        for (int[] flower : flowers) {
            int endTime = flower[1];
            maxTime = Math.max(maxTime, endTime);
        }
        int[] time = new int[maxTime + 1];
        for (int[] flower : flowers) {
            int startTime = flower[0];
            int endTime = flower[1];
            for (int t = startTime; t <= endTime; ++t) {
                time[t]++;
            }
        }
        for (int i = 0; i < people.length; ++i) {
            if (people[i] > maxTime) {
                result[i] = 0;
            } else {
                result[i] = time[people[i]];
            }
        }
        return result;
    }

    public int[] fullBloomFlowers1(int[][] flowers, int[] people) { // brute force // TLE // T = O(f * p), S = O(p)
        int[] result = new int[people.length];
        for (int i = 0; i < result.length; ++i) {
            int count = 0;
            int person = people[i];
            for (int[] flower : flowers) {
                int startTime = flower[0];
                int endTime = flower[1];
                if (person >= startTime && person <= endTime) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
