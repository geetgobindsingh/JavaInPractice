package gfg.amazonprep.arrays;

import java.util.*;

public class FindDuplicatesInAnArray {

    public static void main(String[] args) {
        for (Integer i : duplicates(new int[]{1, 2, 3, 4, 2, 1}, 5))
            System.out.print(i);
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {

        Set<Integer> simple = new HashSet<>();
        Set<Integer> set = new TreeSet<>();
        for (Integer i : arr) {
            if (simple.contains(i)) {
                set.add(i);
            }  else {
                simple.add(i);
            }
        }

        if (set.isEmpty()) {
            set.add(-1);
            return new ArrayList<>(set);
        }
        return new ArrayList<>(set);
    }
}
