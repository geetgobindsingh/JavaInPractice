package gfg.amazonprep.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PositiveNegativePair {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 6, -2, -1, -3, 2, 7};
        for (Integer i : findPairs(arr, arr.length)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> findPairs(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (i > 0) {
                if (set.contains(-i)) {
                    result.add(-i);
                    result.add(i);
                }
            } else {
                if (set.contains(-i)) {
                    result.add(i);
                    result.add(-i);
                }
            }
            set.add(i);
        }
        return result;
    }
}
