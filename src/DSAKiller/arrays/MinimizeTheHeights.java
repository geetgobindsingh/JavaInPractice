package DSAKiller.arrays;

public class MinimizeTheHeights {
    public static void main(String[] args) {
        System.out.println(getMinDiff(new int[]{1, 5, 8, 10}, 4, 2));
        System.out.println(getMinDiff(new int[]{3, 9, 12, 16, 20}, 5, 3));
    }

    public static int getMinDiff(int[] arr, int n, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int diff = max - min;
        if ((max - min) > (2 * k)) {
            max = max - k;
            min = min + k;
            diff = max - min;
        }
        return diff;
    }
}
