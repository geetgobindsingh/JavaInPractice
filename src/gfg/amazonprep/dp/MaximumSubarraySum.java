package gfg.amazonprep.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {
//        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, -2, 5));
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(-2, -3, -4, -1));
        System.out.print(maxSubArray(array));
    }

    public static int maxSubArray(ArrayList<Integer> array) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (Integer i : array) {
            sum = sum + i;
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
