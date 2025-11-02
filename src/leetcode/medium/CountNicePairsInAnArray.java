package leetcode.medium;

import java.util.HashMap;

public class CountNicePairsInAnArray {
    public static void main(String[] args) {
        CountNicePairsInAnArray obj = new CountNicePairsInAnArray();
        System.out.println(obj.countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println(obj.countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }

    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> revMap = new HashMap<>();
        for (int n : nums) {
            int dif = n - rev(n);
            revMap.put(dif, revMap.getOrDefault(n - rev(n), 0) + 1);
        }
        int mod = 1000_000_007;
        long count = 0;
        for (int v : revMap.values()) {
            count = (count + (long) v * (v - 1) / 2) % mod;
        }
        return (int) (count % mod);
    }

    public int countNicePairs1(int[] nums) { // tle
        HashMap<Integer, Integer> revMap = new HashMap<>();
        for (int n : nums) {
            revMap.put(n, rev(n));
        }
        int mod = 109 + 7;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + revMap.get(nums[j]) == nums[j] + revMap.get(nums[i])) {
                    count++;
                }
            }
        }
        return (int) (count % mod);
    }

    private Integer rev(int n) {
        int r = 0;
        while (n > 0) {
            int d = n % 10;
            r = (r * 10) + d;
            n = n / 10;
        }
        return r;
    }
}
