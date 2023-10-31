package gfg.amazonprep.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        for (Integer i : subarraySum(5, 12, new int[]{1, 2, 3, 7, 5})) {
//        for (Integer i : subarraySum(10, 15, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> subarraySum(int n, int s, int[] m) {
        ArrayList<Integer> result = new ArrayList<>();
//        Arrays.sort(m);
        int i = 0;
        while (i < n) {
            int sum = m[i];
            if (sum == s) {
                result.add(i + 1);
                result.add(i + 1);
                break;
            } else {
                int j = i + 1;
                boolean found = false;
                while (sum < s && j <= (n - 1)) {
                    sum = sum + m[j];
                    if (sum == s) {
                        found = true;
                        break;
                    }
                    j++;
                }
                if (found) {
                    result.add(i + 1);
                    result.add(j + 1);
                    break;
                }
            }
            i++;
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}
