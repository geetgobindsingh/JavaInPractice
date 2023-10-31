package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaxAndSecondMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases--;
            int arraySize;
            arraySize = Integer.parseInt(br.readLine());
            int ar[] = new int[arraySize];
            String[] sr = br.readLine().split(" ");
            int index = 0;
            for (String str : sr) {
                ar[index++] = Integer.parseInt(str);
            }
            ArrayList<Integer> aa = largestAndSecondLargest(arraySize, ar);
            for (int i : aa) {
                System.out.print(String.valueOf(i) + " ");
            }
            System.out.println("");
        }

        System.out.println("fin");
    }

    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = -1;
        int secondMax = -1;
        for (int index = 0; index < sizeOfArray; ++index) {
            if (arr[index] > max) {
                secondMax = max;
                max = arr[index];
            } else
                if (arr[index] > secondMax && arr[index] < max) {
                secondMax = arr[index];
            }
        }
        result.add(max);
        result.add(secondMax);
        return result;
    }
}
