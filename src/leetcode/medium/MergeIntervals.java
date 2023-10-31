package leetcode.medium;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        int[][] result = obj.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) { // T = O(nlogn) && S = O(n)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int st = intervals[0][0], ed = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; ++i) {
            int s = intervals[i][0], e = intervals[i][1];
            if (ed < s) {
                ans.add(new int[] {st, ed});
                st = s;
                ed = e;
            } else {
                ed = Math.max(ed, e);
            }
        }
        ans.add(new int[] {st, ed});
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] merge1(int[][] intervals) { // T = O(nlogn) && S = O(N)
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (!st.isEmpty()) {
                int[] peek = st.peek();
                if (intervals[i][0] <= peek[1]) {
                    st.pop();
                    st.push(new int[]{peek[0], Math.max(peek[1], intervals[i][1])});
                } else {
                    st.push(intervals[i]);
                }
            } else {
                st.push(intervals[i]);
            }
        }
        int[][] result = new int[st.size()][2];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            result[i--] = st.pop();
        }
        return result;
    }
}
