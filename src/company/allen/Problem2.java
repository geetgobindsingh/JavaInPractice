package company.allen;

import java.util.*;

public class Problem2 {
    /*
    [10,1,2,7,6,1,5] 8

    return [
    [1,1,6]
    [7,1]
    [1,2,5]
    [2,6]

    ]

     */
    public static void main(String[] args) {
        int ar[] = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        display(findSubsequencesWithSum(ar, target));
    }

    private static void display(List<List<Integer>> ans) {
        for (List<Integer> list : ans) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    private static void display(Set<List<Integer>> ans) {
        for (List<Integer> list : ans) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public static Set<List<Integer>> findSubsequencesWithSum(int[] nums, int target) { // O(nlogn)
        Arrays.sort(nums); // Sort the input array.
        Set<List<Integer>>[] dp = new HashSet[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(new ArrayList());

        for (int num : nums) {
            for (int sum = target; sum >= num; sum--) {
                if (!dp[sum - num].isEmpty()) {
                    Set<List<Integer>> newSubsequences = new HashSet<>();
                    for (List<Integer> subsequence : dp[sum - num]) {
                        List<Integer> newSubsequence = new ArrayList<>(subsequence);
                        newSubsequence.add(num);
                        newSubsequences.add(newSubsequence);
                    }

                    dp[sum].addAll(newSubsequences);
                }
            }
        }

        return dp[target];
    }

    public static Set<List<Integer>> findSubsequencesWithSum1(int[] nums, int target) { // O(2^n)
        Arrays.sort(nums); // Sort the input array to handle duplicates.
        Set<List<Integer>> result = new HashSet<>();
        findSubsequences(nums, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsequences(int[] nums, int index, int target, List<Integer> current, Set<List<Integer>> result) {
        if (target == 0 && current.size() > 0) {
            result.add(new ArrayList<>(current));
        }

        if (index == nums.length) {
            return;
        }

        // Include the current element
        current.add(nums[index]);
        findSubsequences(nums, index + 1, target - nums[index], current, result);
        current.remove(current.size() - 1);

        // Skip duplicate elements
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        // Exclude the current element
        findSubsequences(nums, index + 1, target, current, result);
    }


}
