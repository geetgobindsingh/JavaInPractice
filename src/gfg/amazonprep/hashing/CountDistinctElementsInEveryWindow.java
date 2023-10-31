package gfg.amazonprep.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 1, 3, 4, 2, 3};
        for (Integer i : countDistinct(ar, ar.length, 4)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], (map.get(A[i]) + 1));
            } else {
                map.put(A[i], 1);
                sum++;
            }
        }
        result.add(sum);
        for (int i = 1; i <= (n - k); i++) {
            sum = updateSum(sum, map, A[i - 1]);
            int lastIndex = i + k - 1;
            if (map.containsKey(A[lastIndex])) {
                map.put(A[lastIndex], (map.get(A[lastIndex]) + 1));
            } else {
                map.put(A[lastIndex], 1);
                sum++;
            }
            result.add(sum);
        }
        return result;
    }

    public static int updateSum(int sum, HashMap<Integer, Integer> map, int remove) {
        map.put(remove, map.get(remove) - 1);
        if (map.get(remove) == 0) {
            map.remove(remove);
            return sum - 1;
        }
        return sum;
    }
}
