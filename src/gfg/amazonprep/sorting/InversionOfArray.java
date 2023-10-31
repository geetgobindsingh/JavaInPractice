package gfg.amazonprep.sorting;

import java.util.Arrays;

public class InversionOfArray {
    public static void main(String[] args) {
        System.out.print(inversionCount(new long[]{2, 4, 1, 3, 5}, 5));
    }

    static long inversionCount(long arr[], long N) {
        return mergeSortAndCount(arr, 0, N - 1);
    }

    // Function to count the number of inversions
//     during the merge process
//    private static int mergeAndCount(int[] arr, long l, long m, long r)
//    {
//
//        // Left subarray
//        long[] left = Arrays.copyOfRange(arr, l, m + 1);
//
//        // Right subarray
//        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
//
//        long i = 0, j = 0, k = l, swaps = 0;
//
//        while (i < left.length && j < right.length) {
//            if (left[i] <= right[j])
//                arr[k++] = left[i++];
//            else {
//                arr[k++] = right[j++];
//                swaps += (m + 1) - (l + i);
//            }
//        }
//
//        // Fill from the rest of the left subarray
//        while (i < left.length)
//            arr[k++] = left[i++];
//
//        // Fill from the rest of the right subarray
//        while (j < right.length)
//            arr[k++] = right[j++];
//
//        return swaps;
//    }

    // Merge sort function
    private static int mergeSortAndCount(long[] arr, long l, long r)
    {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            long m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
//            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    static int inversionCount1(long arr[], int N) { // O(n^2)
        int count = 0;
        int length = N;
        long x = arr[0];
        for (int k = 1; k < length; ++k) {
            if (x > arr[k]) {
                for (int j = (k - 1); j >= 0; --j) {
                    if (arr[j] > arr[j + 1]) {
                        count++;
                        swap(arr, j + 1, j);
                    }
                }
            }
            x = arr[k];
        }
        return count;
    }

    private static void swap(long[] ar, int indexA, int indexB) {
        long temp = ar[indexA];
        ar[indexA] = ar[indexB];
        ar[indexB] = temp;

    }
}
