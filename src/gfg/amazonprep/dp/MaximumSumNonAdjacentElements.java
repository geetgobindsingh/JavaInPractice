package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/maximum-sum-non-adjacent-elements-official/ojquestion
public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(findMaxSum(n, ar));
    }

    private static long findMaxSum(int n, int[] ar) {
        int include = ar[0];
        int exclude = 0;
        for (int i = 1; i < n; i++) {
            int oldInclude = include;
            include = exclude + ar[i];
            exclude = Math.max(oldInclude, exclude);
        }
        return Math.max(include, exclude);
    }

    // This is not working, // below is a wrong solution because it is afcted by the order of colors passed
    private static long findMaxSum1(int n, int[] ar) {
        long[] max = new long[n];
        max[0] = ar[0];
        max[1] = Math.max(ar[0], ar[1]);
        for (int i = 2; i < n; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + ar[i]);
        }
        return max[n - 1];
    }

}
