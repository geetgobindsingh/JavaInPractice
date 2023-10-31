package leetcode.medium;

import helper.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        for (List<Integer> list : permute(new int[]{1, 2, 3})) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n---\n");

        for (List<Integer> list : uniquePermute(new int[]{1, 2, 3})) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n---\n");

        for (List<Integer> list : permuteUnique2(new int[]{1, 2, 3})) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(0, nums.length - 1, nums, new ArrayList<Integer>(), result);
        return result;
    }

    public static List<List<Integer>> uniquePermute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        uniquePermutation(0, nums.length - 1, nums, new StringBuilder(), set);

        for (String s : set) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                Integer in = null;
                char ch = s.charAt(i);
                if (ch == '-') {
                    in = Integer.parseInt(s.substring(i, i + 2));
                    i++;
                } else {
                    in = Integer.parseInt(s.substring(i, i + 1));
                }
                list.add(in);
            }
            result.add(list);
        }
        return result;
    }

    private static void permutation(int i, int n, int[] nums, ArrayList<Integer> psf, List<List<Integer>> result) {
        if (psf.size() == n) {
            Integer ob = new Integer(nums[i]);
            psf.add(ob);
            result.add(new ArrayList<>(psf));
            psf.remove(ob);
            return;
        }
        for (int j = i; j <= n; j++) {
            ArrayUtil.swap(nums, i, j);
            Integer ob = new Integer(nums[i]);
            psf.add(ob);
            permutation(i + 1, n, nums, psf, result);
            psf.remove(ob);
            ArrayUtil.swap(nums, i, j);
        }
    }

    private static void uniquePermutation(int i, int n, int[] nums, StringBuilder psf, HashSet<String> result) {
        if (i == n) {
            psf.append(nums[i]);
            result.add(psf.toString());
            if (nums[i] < 0) {
                psf.deleteCharAt(psf.length() - 1);
                psf.deleteCharAt(psf.length() - 1);
            } else {
                psf.deleteCharAt(psf.length() - 1);
            }
            return;
        }
        for (int j = i; j <= n; j++) {
            ArrayUtil.swap(nums, i, j);
            psf.append(nums[i]);
            uniquePermutation(i + 1, n, nums, psf, result);
            if (nums[i] < 0) {
                psf.deleteCharAt(psf.length() - 1);
                psf.deleteCharAt(psf.length() - 1);
            } else {
                psf.deleteCharAt(psf.length() - 1);
            }
            ArrayUtil.swap(nums, i, j);
        }
    }

    public static List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates

        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        backtrack(nums, used, current, result);

        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue; // Skip duplicates or already used elements
            }

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }


}
