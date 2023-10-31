package pepcoding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpanOfArray {
    //You are required to find the span of input.
    // Span is defined as difference of maximum value and minimum value.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n];
        int index = 0;
        while (n-- > 0) {
            ar[index++] = Integer.parseInt(br.readLine());
        }

        System.out.println(findSpan(ar, ar.length));
    }

    private static int findSpan(int[] ar, int n) {
        if (n == 0) {
            return 0;
        }
        int maxIndex = 0;
        int minIndex = 0;
        for (int index = 1; index < n; index++) {
            if (ar[index] < ar[minIndex]) {
                minIndex = index;
            }
            if (ar[index] > ar[maxIndex]) {
                maxIndex = index;
            }
        }
        return ar[maxIndex] - ar[minIndex];
    }
}
