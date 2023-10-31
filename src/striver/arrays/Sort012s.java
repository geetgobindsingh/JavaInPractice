package striver.arrays;

import java.util.*;

public class Sort012s {
    public static void main(String[] args) {
        int[] ar = new int[] {2, 0, 2, 1, 1, 0};
        insertionSort(ar);
        display(ar);
        ar = new int[] {2, 0, 2, 1, 1, 0};
        mergeSort(ar);
        display(ar);
        ar = new int[] {2, 0, 2, 1, 1, 0};
        countSort(ar);
        display(ar);
        // dutch national park algo
        ar = new int[] {2, 0, 2, 1, 1, 0};
        dutchNationalFlag(ar);
        display(ar);
    }

    private static void display(int[] ar) {
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            System.out.print(ar[i]);
            if (i < (n - 1)) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private static void insertionSort(int[] ar) { // O(N^2)
        int n = ar.length;
        int x = ar[0];
        for (int i = 1; i < n; i++) {
            if (x > ar[i]) {
                for (int j = i - 1; j >= 0; j--) {
                    if (ar[j] > ar [j + 1]) {
                        swap(ar, j, j + 1);
                    }
                }
            }
            x = ar[i];
        }
    }

    private static void mergeSort(int[] ar) { // O(NlogN)
        doMergeSort(ar, 0, ar.length - 1);
    }

    private static void doMergeSort(int[] ar, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            doMergeSort(ar, left, mid);
            doMergeSort(ar, mid + 1, right);
            merger(ar, left, mid, right);
        }
    }

    private static void merger(int[] ar, int left, int mid, int right) {
        int l = right - left + 1;
        int m = mid - left + 1;
        int n = right -  mid;

        int a[] = new int[m];
        int b[] = new int[n];

        for (int i = 0; i < m; i++ ) {
            a[i] = ar[i + left];
        }
        //System.arraycopy(ar, left, m, destPos, len);
        for (int j = 0; j < n; j++ ) {
            b[j] = ar[j + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = left;

        for (int index = 0; index < l; index++) {
            if (i < m && j < n) {
                if (a[i] <= b[j]) {
                    ar[k++] = a[i++];
                } else {
                    ar[k++] = b[j++];
                }
                continue;
            }
            if (i < m) {
                ar[k++] = a[i++];
                continue;
            }
            if (j < n) {
                ar[k++] = b[j++];
                continue;
            }
        }
    }

    private static void countSort(int[] ar) { // O(2xN)
        int uniqueElement = 3;
        int[] countArray = new int[uniqueElement];
        int n = ar.length;
        for (int i = 0;i < n; i++) {
            countArray[ar[i]]++;
        }
        int k = 0;
        for (int i = 0; i < 3; i++) {
            if (countArray[i] > 0) {
                for (int j = 0; j < countArray[i]; j++) {
                    ar[k++] = i;
                }
            }
        }
    }

    private static void dutchNationalFlag(int[] ar) { // O(N)
        int n = ar.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid < high) {
            switch (ar[mid]) {
                case 0: {
                    swap(ar, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(ar, mid, high);
                    high--;
                    break;
                }
            }
        }
    }
}
