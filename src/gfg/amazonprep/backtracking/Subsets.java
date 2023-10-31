package gfg.amazonprep.backtracking;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        int ar[] = new int[]{1, 2, 2};
        System.out.println("-");
        ArrayList<ArrayList<Integer>> res = AllSubsets(ar, ar.length);
        System.out.println(res.size());
        for (ArrayList<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("-");
    }

    // FASTEST
    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        TreeSet<String> set = new TreeSet<>();
        getSubSets(0, arr, n, new StringBuilder(), set);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (String val : set) {
            ArrayList<Integer> list = new ArrayList<>();
            for (String v : val.split(" ")) {
                list.add(Integer.parseInt(v));
            }
            result.add(list);
        }
        return result;
    }


    private static void getSubSets(int index, int[] arr,
                                   int n,
                                   StringBuilder val,
                                   TreeSet<String> result) {
        if (index == n) {
            if (val.length() != 0) {
                result.add(val.toString().trim());
            }
            return;
        }
        getSubSets(index + 1, arr, n, new StringBuilder(val), result);
        getSubSets(index + 1, arr, n, new StringBuilder(val).append(arr[index]).append(" "), result);
    }


    public static ArrayList<ArrayList<Integer>> AllSubsets1(int arr[], int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 1; i <= 2; i++) {
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < (n - i + 1); j++) {
                int k = 0;
                int sect = 0;
                while (k < (n - i)) {
                    temp.add(arr[j + k]);
                    sect = sect * 10 + arr[j + k];
                    k = k + i;
                }
                if (!set.contains(sect)) {
                    set.add(sect);
                    result.add(new ArrayList<>(temp));
                }
                temp.clear();
            }
        }
        return result;
    }
}
