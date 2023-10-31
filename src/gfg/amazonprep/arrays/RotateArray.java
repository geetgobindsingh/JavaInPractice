package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases--;
            String[] sr = br.readLine().split(" ");
            int arraySize = Integer.parseInt(sr[0]);
            int dist = Integer.parseInt(sr[1]);
            int ar[] = new int[arraySize];
            String[] arr = br.readLine().split(" ");
            int index = 0;
            for (String str : arr) {
                ar[index++] = Integer.parseInt(str);
            }
            rotateArr(ar, dist, arraySize);
            for (int i : ar) {
                System.out.print(String.valueOf(i) + " ");
            }
        }

        System.out.println("");
        System.out.println("fin");
    }

    /*
    2
    5 2
    1 2 3 4 5
    10 3
    2 4 6 8 10 12 14 16 18 20
     */

    private static void swap(int arr[], int index_a, int index_b) {
        int temp = arr[index_a];
        arr[index_a] = arr[index_b];
        arr[index_b] = temp;
    }

    private static void rotateArr(int arr[], int d, int n) {
        int i = d - 1;
        int max = n - d;
        for (; i >= 0; i--) {
            int j = i;
            for (int k = 0; k < max; k++) {
                swap(arr, j, j + 1);
                j++;
            }
        }
    }

    private static void rotateArr2(int arr[], int d, int n) {
        int a[] = new int[n];
        int i = 0;
        int index = d;
        for (; index < n; index++) {
            a[i++] = arr[index];
        }
        index = 0;
        for (; index < d; index++) {
            a[i++] = arr[index];
        }
        for (index = 0; index < n; index++) {
            arr[index] = a[index];
        }
    }
}
