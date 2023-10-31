package gfg.amazonprep.arrays;

import java.util.ArrayList;
import java.util.TreeSet;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] ar1 = new int[]{1, 2, 3, 4, 5};
        int[] ar2 = new int[]{1, 2, 3};
        for (Integer i : findUnion(ar1, ar2, ar1.length, ar2.length)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int j : arr2) {
            set.add(j);
        }
        return new ArrayList<>(set);
    }
}
