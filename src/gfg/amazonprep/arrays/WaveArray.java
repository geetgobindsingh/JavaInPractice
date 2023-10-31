package gfg.amazonprep.arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        convertToWave(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void convertToWave(int arr[], int n) {
        if (n == 0 || n == 1) {
            return;
        }
        if (n == 2) {
            swap(arr, 0, 1);
            return;
        }
        for (int i = 0; i < (n - 1); i = i + 2) {
            swap(arr, i, i + 1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
