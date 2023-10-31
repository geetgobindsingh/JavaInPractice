package gfg.amazonprep.hashing;

import java.util.HashMap;

public class LargestSubarrayOf0sAnd1s {
    public static void main(String[] args) {
        int ar[] = new int[]{0, 1, 0, 1};
        System.out.print(maxLen(ar, ar.length));
    }

    public static int maxLen(int[] arr, int n) {
        for (int i =0; i < n ; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = -1;
        int endIndex = -1;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == 0) { //  need to understand why this hacky why?
                maxLength = i + 1;
                endIndex = i;
            }
            if (map.containsKey(sum)) {
                maxLength = Integer.max(maxLength, i - map.get(sum));
                endIndex = i;
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
