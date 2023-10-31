package gfg.amazonprep.dp;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrintAllLongestIncreasingSubsequences {
    public static class Pair {
        int l; // length
        int i; // index
        int v; // value
        String psf; // path so far

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    /*
    8
52
9
11
56
23
59
18
91
5
     */

    public static void solution(int[] arr) {
        int dp[] = new int[arr.length];
        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (max < dp[j]) {
                        max = dp[j];
                    } else if (max == dp[j]) {

                    }
                }
            }
            dp[i] = max + 1;
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }
        System.out.println(maxLength);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] == maxLength) {
                queue.add(new Pair(maxLength, i, arr[i], arr[i] + ""));
            }
        }
        while (!queue.isEmpty()) {
            Pair current = queue.removeFirst();
            if (current.l == 1) {
                System.out.println(current.psf);
            }
            for (int i = current.i - 1; i >= 0; i--) {
                if (dp[i] == current.l - 1 && arr[i] <= current.v) {
                    queue.add(new Pair(dp[i], i, arr[i], arr[i] + " -> " + current.psf));
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }

}
