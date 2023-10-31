package gfg.amazonprep.dp;

public class MaximizeTheCutSegments {
    public static void main(String[] args) {
        System.out.println(maximizeCuts(4, 2, 1, 1));
    }

    public static int maximizeCuts(int n, int x, int y, int z) {
        int max = Integer.MIN_VALUE;
        max = Math.max(max, (int) Math.ceil(n / x));
        max = Math.max(max, (int) Math.ceil(n / y));
        max = Math.max(max, (int) Math.ceil(n / z));
        return max;
    }
}
