package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList();
        backTracking(0, 10, 7, new ArrayList<>(), list);
        for (List<Integer> listi : list) {
            for (Integer i : listi) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public static void backTracking(int i, int n, int k, List<Integer> asf, List<List<Integer>> result) {
        if (asf.size() == k) {
            result.add(new ArrayList<>(asf));
            return;
        }
        if (i == n) {
            return;
        }

        Integer ob = new Integer(i + 1);
        asf.add(ob);
        backTracking(i + 1, n, k, asf, result);
        asf.remove(ob);
        backTracking(i + 1, n, k, asf, result);
    }
}
