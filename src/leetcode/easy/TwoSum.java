package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,7,11,55};
//        int target = 66;
        int[] nums = new int[]{3,2,4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] solution = twoSum.twoSum(nums, target);
        for (int value : solution) {
            System.out.println(value);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int dif = target - nums[i];
            if (map.containsKey(dif)) {
                arr[0] = map.get(dif);
                arr[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return arr;
    }

    public int[] twoSum2(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            map.put(index, nums[index]);
            int dif = target - nums[index];
            if (map.containsValue(dif)) {
                result[0] = getKeyByValue(map, dif);
                result[1] = index;
                if (result[0] == result[1]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
