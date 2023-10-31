package gfg.amazonprep.arrays;

public class SticklerThief {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.print(FindMaxSum(arr, arr.length));
    }

    public static int FindMaxSum(int arr[], int n) {
        int M[] = new int[n];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return Math.max(arr[0], arr[1]);
        }
        M[0] = arr[0];
        M[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            M[i] = Math.max(M[i - 1], arr[i] + M[i - 2]);
        }
        return M[n - 1];
    }
}
