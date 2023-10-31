package daa.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter comma separated integer numbers in sorted order:");
        String[] input = br.readLine().split(",");
        int[] ar = new int[input.length];
        int index = 0;
        for (String str : input) {
            ar[index++] = Integer.parseInt(str);
        }
        System.out.println("Enter Number to search");
        int inputNumber = Integer.parseInt(br.readLine());
        System.out.println("index is " + binarySearch(ar, inputNumber));
    }

    private static int binarySearch(int[] ar, int inputNumber) {
        int result = -1;
        int low = 0, mid = 0, high = 0;
        high = ar.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (ar[mid] == inputNumber) {
                return mid;
            } else if (ar[mid] < inputNumber) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
