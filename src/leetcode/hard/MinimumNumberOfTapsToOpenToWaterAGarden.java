package leetcode.hard;

import java.util.HashSet;

public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public static void main(String[] args) {
        MinimumNumberOfTapsToOpenToWaterAGarden obj = new MinimumNumberOfTapsToOpenToWaterAGarden();
//        System.out.println(obj.minTaps2(5, new int[]{3,4,1,1,0,0}));
//        System.out.println(obj.minTaps2(7, new int[]{1,2,1,0,2,1,0,1}));
        System.out.println(obj.minTaps2(8, new int[]{4, 0, 0, 0, 4, 0, 0, 0, 4}));
    }

    public static void display(HashSet<Integer>[] ar, int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print("(");
            for (int j : ar[i]) {
                System.out.print(ar[i] + " ");
            }
            System.out.print(")");
        }
        System.out.print("\n");
    }

    public static void display(int[] ar, int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.print("\n");
    }

    public int minTaps(int n, int[] ranges) {
        int[] last = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            int l = Math.max(0, i - ranges[i]), r = i + ranges[i];
            last[l] = Math.max(last[l], r);
        }
        int ans = 0, mx = 0, pre = 0;
        for (int i = 0; i < n; ++i) {
            mx = Math.max(mx, last[i]);
            if (mx <= i) {
                return -1;
            }
            if (pre == i) {
                ++ans;
                pre = mx;
            }
        }
        return ans;
    }

    public int minTaps2(int n, int[] ranges) {
        display(ranges, n);
        int[] indeces = new int[n + 1];
        HashSet<Integer>[] filled = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            int range = ranges[i];
            int j = i;
            while (j <= (i + range + 1) && j <= n) {
                if (filled[j] == null) {
                    filled[j] = new HashSet<>();
                }
                filled[j].add(i);
                indeces[j] = i;
                j++;
            }
        }
        display(filled, n);
        display(indeces, n);
        for (int i = n; i >= 0; i--) {
            int range = ranges[i];
            int j = i;
            while (j >= 0 && j >= (i - (range + 1))) {
                if (filled[j] == null) {
                    filled[j] = new HashSet<>();
                }
                filled[j].add(ranges[i]);
                indeces[j] = i;
                j--;
            }
        }
        display(filled, n);
        display(indeces, n);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            if (filled[i] == null) return -1;
            set.add(indeces[i]);
        }

        return set.size();
    }
}
