package gfg.amazonprep.hashing;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int ar[] = new int[]{15, -2, 2, -8, 1, 7, 10, 23};
        System.out.print(maxLen(ar, ar.length));
    }

    public static int maxLen(int arr[], int n) {
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
