package gfg.amazonprep.arrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int a[] = new int[]{89, 24, 75, 11, 23};
        int b[] = new int[]{89, 2, 4};
        System.out.print(NumberofElementsInIntersection(a, b, a.length, b.length));
    }

    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int count = 0;
        if (n >= m) {
            for (int i : a) {
                set.add(i);
            }
            for (int j : b) {
                if (set.contains(j) && !set2.contains(j)) {
                    set2.add(j);
                    count++;
                }
            }
        } else {
            for (int i : b) {
                set.add(i);
            }
            for (int j : a) {
                if (set.contains(j) && !set2.contains(j)) {
                    set2.add(j);
                    count++;
                }
            }
        }
        return count;
    }
}
