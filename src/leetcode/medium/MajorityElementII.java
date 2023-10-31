package leetcode.medium;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    //Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    /*
    Constraints:
    1 <= nums.length <= 5 * 10^4
    -10^9 <= nums[i] <= 10^9
    Follow up: Could you solve the problem in linear time and in O(1) space?
     */
    public static void main(String[] args) {
        MajorityElementII obj = new MajorityElementII();
        System.out.println(obj.majorityElement(new int[]{3, 2, 3})); //3
        System.out.println(obj.majorityElement(new int[]{1})); //1
        System.out.println(obj.majorityElement(new int[]{1, 2})); //1,2
    }

    public static class Pair implements Comparable<Pair> {
        int key;
        int count;

        public Pair(int key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return Integer.compare(this.count, o.count);
        }
    }

    // n = 10
    // n/3 = 10/3 = 3
    // So if two number exist more than 3 times, than they must have to be present in the array atleast 4 times.
    // And therefore 10 - (2*4) = 2, so only 2 numbers left.
    // This is valid for all array sizes.
    // The most optimal way to find this two numbers is using Boyer Moore's Voting Algo.
    // Time Complexity = O(n) to find the two numbers + O(n) to check if the numbers actually exist more than {n/3} times. = O(2n) = O(n)
    // Space Complexity = O(1)
    public List<Integer> majorityElement(int[] nums) { // T = O(n) && S = O(1)
        int num1 = 0, count1 = 0, num2 = 0, count2 = 0;

        // Find the numbers which exist in the array most
        for (int num : nums) {

            if (num == num1) {
                ++count1;
            } else if (num == num2) {
                ++count2;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }

        // Find the total number of times {num1} and {nums2} are present in the array
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == num1) {
                ++count1;
            } else if (num == num2) {
                ++count2;
            }
        }
        int required = nums.length / 3;

        List<Integer> result = new ArrayList<Integer>();

        // Add the numbers to the result if they exist more than {n/3} times.
        if (count1 > required) {
            result.add(num1);
        }

        if (count2 > required) {
            result.add(num2);
        }

        return result;
    }

    public List<Integer> majorityElement1(int[] nums) { // T = O(n) && S = O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int minCount = nums.length / 3;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > minCount) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
