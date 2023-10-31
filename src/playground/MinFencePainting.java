package playground;

public class MinFencePainting {
    public static void main(String[] args) {
        int ar[][] = new int[][]{
                {2, 9, 2},
                {7, 70, 71},
                {18, 12, 19}
        };
        System.out.println(minFence(ar));
    }

    private static int minFence(int[][] ar) {
        if (ar.length == 0) {
            return 0;
        }
        int n = ar.length;
        int sum = 0;
        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            lastIndex = getMinIndex(ar[i], lastIndex);
            sum = sum + ar[i][lastIndex];
        }
        return sum;
    }

    private static int getMinIndex(int[] ar, int excludeIndex) {
        int min = -2;
        for (int i = 0; i < 3; i++) {
            if (((min == -2) || (ar[min] > ar[i])) && excludeIndex != i) {
                min = i;
            }
        }
        return min;
    }
}
