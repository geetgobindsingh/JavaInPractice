package leetcode.medium;

import java.util.*;
public class ConvertAnArrayIntoA2DArrayWithConditions {
    public static void main(String[] args) {
        ConvertAnArrayIntoA2DArrayWithConditions obj = new ConvertAnArrayIntoA2DArrayWithConditions();
        for (List<Integer> list : obj.findMatrix(new int[]{1,3,4,1,2,3,1})) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = null;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                set = new HashSet<>();
                dfs(i, nums, visited, set, result, new ArrayList<>());
            }
        }
        return result;
    }

    private void dfs(int i, int[] nums, boolean[] visited, Set<Integer> set,
                     List<List<Integer>> result, List<Integer> list) {
        if (i == nums.length) {
            list.addAll(set);
            result.add(list);
            return;
        }
        if (visited[i]) {
            dfs(i + 1, nums, visited, set, result, list);
            return;
        }

        if (set.add(nums[i])) {
            visited[i] = true;
            dfs(i + 1, nums, visited, set, result, list);
        } else {
            dfs(i + 1, nums, visited, set, result, list);
        }
    }
}
