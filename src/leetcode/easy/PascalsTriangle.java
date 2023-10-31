package leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        for (List<Integer> l : obj.generate(31)) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        for(int i=1;i<=numRows;i++) {
            l1 = rowGen(i);
            result.add(l1);
        }
        return result;
    }
    public static List<Integer> rowGen(int r) {
        List<Integer> f = new ArrayList<>();
        for (int i = 0; i < r; ++i) {
            f.add(1);
        }
        for (int i = 2; i < r; ++i) {
            for (int j = i - 1; j > 0; --j) {
                f.set(j, f.get(j) + f.get(j - 1));
            }
        }
        return f;
    }
    public static List<Integer> rowGen2(int r) {
        List<Integer> rowList = new ArrayList<>();
        int ans = 1;
        rowList.add(1);
        for(int i=1;i<r;i++) {
            ans = ans*(r-i);
            ans = ans/i;
            rowList.add(ans);
        }
        return rowList;
    }
    public List<List<Integer>> generate2(int numRows) {
        int n = 1;
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        if (n == numRows) {
            return result;
        }
        n++;
        result.add(Arrays.asList(1, 1));
        if (n == numRows) {
            return result;
        }
        n++;
        int[] old = new int[]{1,1};
        while (n <= numRows) {
            int[] ar = new int[n];
            ar[0] = 1;
            for (int i = 1; i < old.length; i++) {
                ar[i] = old[i] + old[i - 1];
            }
            ar[n - 1] = 1;
            old = ar;
            n++;
            result.add(Arrays.stream(ar)
                    .mapToObj(Integer::valueOf)
                    .collect(Collectors.toList()));
        }
        return result;
    }
}
