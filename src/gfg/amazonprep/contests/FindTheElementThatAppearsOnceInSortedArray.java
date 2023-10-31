package gfg.amazonprep.contests;

import java.util.HashSet;
import java.util.Set;

public class FindTheElementThatAppearsOnceInSortedArray {
    public static void main(String[] args) {
        System.out.print(appearsOnce(new long[]{1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}, 11));
        System.out.print(appearsOnce(new long[]{5, 5, 8}, 3));
    }

    public static long appearsOnce(long a[], int n) {
        long result = 0;
        Set<Long> set = new HashSet<>();
        for (long item : a) {
            if (set.contains(item)) {
                result = result - item;
            } else {
                result = result + item;
                set.add(item);
            }
        }
        return result;
    }
}
