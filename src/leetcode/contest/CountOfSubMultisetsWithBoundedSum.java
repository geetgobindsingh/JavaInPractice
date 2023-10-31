package leetcode.contest;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class CountOfSubMultisetsWithBoundedSum {
    public static void main(String[] args) {
        CountOfSubMultisetsWithBoundedSum obj = new CountOfSubMultisetsWithBoundedSum();
        //System.out.println(obj.countSubMultisets(Arrays.asList(1, 2, 2, 3), 6, 6));
        System.out.println(obj.countSubMultisets(Arrays.asList(2, 1, 4, 2, 7), 1, 5));
    }

    public int countSubMultisets(List<Integer> nums, int l, int r) {
        TreeSet<String> set = new TreeSet<>();
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        getSubSets(0, arr, nums.size(), new StringBuilder(), set, l, r);
        return set.size();
    }


    private static void getSubSets(int index, int[] arr,
                                   int n,
                                   StringBuilder val,
                                   TreeSet<String> result, int l, int r) {
        int sum = getSum(val.toString());
        if (sum >= l && sum <= r) {
            System.out.println(val + " : " + sum);
            result.add(val.toString().trim());
        }
        if (index == n) {
            return;
        }
        getSubSets(index + 1, arr, n, new StringBuilder(val), result, l, r);
        getSubSets(index + 1, arr, n, new StringBuilder(val).append(arr[index]), result, l, r);
    }

    private static int getSum(String val) {
        int sum = 0;
        for (int i = 0; i < val.length(); ++i) {
            sum = sum + Integer.parseInt(String.valueOf(val.charAt(i)));
        }
        return sum;
    }
}
