package gfg.amazonprep.sorting;

import java.util.Arrays;

public class CountPossibleTriangles {
    public static void main(String[] args) {
//        int[] ar = new int[]{6, 4, 9, 7, 8};
        int[] ar = new int[]{1, 2, 2, 2, 1, 1};
//        int[] ar = new int[]{1, 2, 2, 3, 1, 3};
        //. For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side).
        System.out.print(findNumberOfTriangles(ar, ar.length));
    }

    public static int findNumberOfTriangles(int arr[], int n) {
        // Sort the array elements in non-decreasing order
        Arrays.sort(arr);

        // Initialize count of triangles
        int count = 0;

        // Fix the first element. We need to run till n-3 as
        // the other two elements are selected from arr[i+1...n-1]
        for (int i = 0; i < n - 2; ++i) {
            // Initialize index of the rightmost third element
            int k = i + 2;

            // Fix the second element
            for (int j = i + 1; j < n; ++j) {
                /* Find the rightmost element which is smaller
                than the sum of two fixed elements
                The important thing to note here is, we use
                the previous value of k. If value of arr[i] +
                arr[j-1] was greater than arr[k], then arr[i] +
                arr[j] must be greater than k, because the
                array is sorted. */
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;

                /* Total number of possible triangles that can be
                formed with the two fixed elements is k - j - 1.
                The two fixed elements are arr[i] and arr[j]. All
                elements between arr[j+1] to arr[k-1] can form a
                triangle with arr[i] and arr[j]. One is subtracted
                from k because k is incremented one extra in above
                while loop. k will always be greater than j. If j
                becomes equal to k, then above loop will increment
                k, because arr[k] + arr[i] is always/ greater than
                arr[k] */
                if (k > j)
                    count += k - j - 1;
            }
        }
        return count;
    }
    public static int findNumberOfTriangles1(int arr[], int n) {
        int count = 0;
        Arrays.sort(arr);
        for (int index = 0; index < n; index++) {
            int x = arr[index];
            int i = index + 1;
            while (i < n) {
                if ((i + 1) < n && arr[i] == arr[i + 1]) {
                    count = count + 1;
                    int k = i + 1;
                    while (k < n && arr[k] == arr[i]) {
                        k++;
                    }
                    i = k - 1;
                } else {
                    count++;
                    i++;
                }
            }
            while (index < n && arr[index] == x) {
                index++;
            }
        }
        return count;
    }

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
