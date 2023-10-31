package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryArraySorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases = tesCases - 1;
            int arraySize = Integer.parseInt(br.readLine());
            int ar[] = new int[arraySize];
            String[] sr = br.readLine().split(" ");
            int index = 0;
            for (String str : sr) {
                ar[index++] = Integer.parseInt(str);
            }
            int aa[] = SortBinaryArray(ar, arraySize);
            for (int i : aa) {
                System.out.print(String.valueOf(i) + " ");
            }
            System.out.println("");
        }

        System.out.println("fin");
    }

    private static int[] SortBinaryArray(int arr[], int n) {
        int leftIndex = 0;
        int rightIndex = n - 1;
        while (leftIndex < rightIndex) {
            while (leftIndex < n && arr[leftIndex] == 0) {
                leftIndex++;
            }
            while (rightIndex > 0 && arr[rightIndex] == 1) {
                rightIndex--;
            }
            if (leftIndex < n && rightIndex > 0 && leftIndex < rightIndex) {
                arr[leftIndex] = 0;
                arr[rightIndex] = 1;
                leftIndex++;
                rightIndex--;
            }
        }
        return arr;
    }
}
