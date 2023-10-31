package leetcode.hard;

public class MaximumRunningTimeOfNComputers {
    public static void main(String[] args) {
        System.out.println(maxRunTime(2, new int[]{3, 3, 3}));
    }

    // binary search
    public static long maxRunTime(int n, int[] batteries) {
        // find range for binary search 1 to r
        int r = 0;
        for (int m : batteries) {
            r = r + m;
        }

        r = r / n;

        int l = 1;

        int result = 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (checkPossibility(n, batteries, mid)) {
                l = mid;
                result = mid;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    private static boolean checkPossibility(int n, int[] batteries, int maxRunTime) {
        int minSum = 0;
        for (int m : batteries) {
            minSum = minSum + Math.min(maxRunTime, m);
        }
        return minSum >= (n * maxRunTime);
    }
}
