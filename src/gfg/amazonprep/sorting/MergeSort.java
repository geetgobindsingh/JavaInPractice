package gfg.amazonprep.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 5, 1, 2};
        applyMergeSort(input, 0, input.length - 1);
        for (Integer n : input) {
            System.out.print(n + " ");
        }
    }

    private static void applyMergeSort(int[] input, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) / 2);
            applyMergeSort(input, left, mid);
            applyMergeSort(input, mid + 1, right);
            merge(input, left, mid, right);
        }
    }

    private static void merge(int[] input, int left, int mid, int right) {
        int m = mid - left + 1;
        int n = right - mid;

        int L[] = new int[m];
        int R[] = new int[n];

        for (int i = 0; i < m; i++) {
            L[i] = input[left + i];
        }

        for (int j = 0; j < n; j++) {
            R[j] = input[mid + j + 1];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < m && j < n) {
            if (L[i] < R[j]) {
                input[k] = L[i];
                k++;
                i++;
            } else {
                input[k] = R[j];
                k++;
                j++;
            }
        }

        while (i < m) {
            input[k] = L[i];
            k++;
            i++;
        }

        while (j < n) {
            input[k] = R[j];
            k++;
            j++;
        }
    }


}
