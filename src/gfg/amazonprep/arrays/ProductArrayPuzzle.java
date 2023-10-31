package gfg.amazonprep.arrays;

public class ProductArrayPuzzle {
    public static void main(String[] args) {
//        for (Long i : productExceptSelf(new int[]{10, 3, 5, 6, 2}, 5))
//        for (Long i : productExceptSelf(new int[]{3,1,1,1,3}, 5))
        for (Long i : productExceptSelf(new int[]{17, 8, 6, 4, 6, 7, 3, 10, 2,
                3, 8, 1, 10, 4, 7, 1, 7, 3, 7, 2, 9, 8,
                10, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1}, 34))
            System.out.print(i + " ");
    }

    public static long[] productExceptSelf(int arr[], int n) {
        long ar[] = new long[n];
        ar[0] = 1;
        for (int index = 1; index < n; index++) {
            ar[index] = ar[index - 1] * arr[index - 1];
        }
        long mux = arr[n - 1];
        for (int index = n - 2; index >= 0; index--) {
            ar[index] = ar[index] * mux;
            mux = mux * arr[index];
        }
        return ar;
    }
}
