package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        //System.out.println(findLongestChain(new int[][]{{1,2}, {7,8}, {4,5}}));
        //System.out.println(findLongestChain(new int[][]{{1,2}, {2, 3}, {4,5}}));
        System.out.println(findLongestChainDP(new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}}));
        System.out.println(findLongestChainGreedy(new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}}));
    }

    public static int findLongestChainGreedy(int[][] pairs) { // O(nlogn)
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int cur = Integer.MIN_VALUE, ans = 0;

        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }

        return ans;
    }

    public static int findLongestChainDP(int[][] pairs) { // O(n^2)
        int n = pairs.length;
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(pairs[i][0], pairs[i][1]));
        }
        Collections.sort(list);
        for (int j = 0; j < n; j++) {
            System.out.print(list.get(j).a + " " + list.get(j).b + ", ");
        }
        int maxLength = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(i).b > list.get(j).b && list.get(i).a != list.get(j).b) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }
        for (int j = 0; j < n; j++) {
            System.out.print(dp[j] + " ");
        }
        return maxLength;
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.a == other.a) {
                return this.b - other.b;
            } else {
                return this.a - other.a;
            }
        }
    }
}
