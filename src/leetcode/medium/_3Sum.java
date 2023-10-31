package leetcode.medium;

import java.util.*;

public class _3Sum {
    public static void main(String[] args) {
        for (List<Integer> list : threeSum(new int[]{-1, 0, 1, 2, -1, -4})) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) { // O(NlogN)
        List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    set.add(list);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return set;
    }

    public static List<List<Integer>> threeSum2(int[] nums) { // O(N^3)
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.clear();
            map.put(nums[i], i);
            for (int j = i + 1; j < nums.length; j++) {
                int dif = -(nums[i] + nums[j]);
                if (map.containsKey(dif)
                        && map.get(dif) != i
                        && map.get(dif) != j
                        && i != j) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], dif);
                    Collections.sort(list);
                    set.add(list);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(set);
    }
}
