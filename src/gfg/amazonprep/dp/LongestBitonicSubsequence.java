package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestBitonicSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
//        int ar[] = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.print(longestBitonicSubsequence(ar.length, ar));
    }

    private static long longestBitonicSubsequence(int length, int[] ar) {
        long maxLength = 0;

        long[] dpIncreasing = new long[length];
        for (int i = 0; i < length; i++) {
            long max = 0;
            for (int j = 0; j < i; j++) {
                if (ar[j] <= ar[i]) {
                    if (dpIncreasing[j] > max) {
                        max = dpIncreasing[j];
                    }
                }
            }
            dpIncreasing[i] = max + 1;
        }
        long[] dpDecreasing = new long[length];
        for (int i = length - 1; i >= 0; i--) {
            long max = 0;
            for (int j = length - 1; j > i; j--) {
                if (ar[j] <= ar[i]) {
                    if (dpDecreasing[j] > max) {
                        max = dpDecreasing[j];
                    }
                }
            }
            dpDecreasing[i] = max + 1;
        }

        for (int i = 0; i < length; i++) {
            long val = dpIncreasing[i] + dpDecreasing[i] - 1;
            if (val > maxLength) {
                maxLength = val;
            }
        }
        return maxLength;
    }
}
