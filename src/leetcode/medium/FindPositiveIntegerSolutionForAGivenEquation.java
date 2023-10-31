package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {
    public static void main(String[] args) {
        printSolution(findSolution((x, y) -> x + y, 5));
        System.out.print("\n");
        printSolution(findSolution((x, y) -> x * y, 5));
    }

    private static void printSolution(List<List<Integer>> solution) {
        for (List<Integer> l : solution) {
            StringBuilder s = new StringBuilder();
            for (Integer i : l) {
                s.append(i).append(" ");
            }
            System.out.println(s);
        }
    }

    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int l = 1;
            int r = 1000;
            while (l < r) {
                int mid = (l + r) / 2;
                if (customfunction.f(i, mid) >= z) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (customfunction.f(i, l) == z) {
                result.add(Arrays.asList(i, l));
            }
        }
        return result;
    }



    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     * class CustomFunction {
     *     // Returns f(x, y) for any given positive integers x and y.
     *     // Note that f(x, y) is increasing with respect to both x and y.
     *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *     public int f(int x, int y);
     * };
     */

    interface CustomFunction {
        public
            // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
        int f(int x, int y);
    }

    ;
}
