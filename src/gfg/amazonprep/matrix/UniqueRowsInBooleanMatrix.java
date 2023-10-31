package gfg.amazonprep.matrix;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class UniqueRowsInBooleanMatrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}};
        for (ArrayList<Integer> list : uniqueRow(a, a.length, a[0].length)) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedHashSet<String> stringSet = new LinkedHashSet<>();
        for (int i = 0; i < r; i++) {
            String s = "";
            for (int j = 0; j < c; j++) {
                s = s + a[i][j];
            }
            stringSet.add(s);
        }
        for (String s : stringSet) {
            ArrayList<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                sublist.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            }
            result.add(sublist);
        }

        return result;
    }
}
