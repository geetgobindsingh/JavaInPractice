package striver.arrays;

import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        bruteForceNextPermutation(nums);
        display(nums);
        nums = new int[]{1, 3, 2};
        optimisedNextPermutation(nums);
        display(nums);
    }


    private static void display(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    private static void bruteForceNextPermutation(int[] nums) { // O(N^2)
        int b[] = new int[nums.length];
        System.arraycopy(nums, 0, b, 0, nums.length);
        Arrays.sort(b);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permutate(result, b, 0, b.length - 1);
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        int index = 0;
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (ArrayList<Integer> list :result) {
            String item = list.toString();
            if (!set.contains(item)) {
                set.add(item);
                finalResult.add(list);
            }
        }
        for (ArrayList<Integer> list : finalResult) {
            boolean found = true;
            for (int i = 0; i < nums.length; ++i) {
                if (list.get(i) != nums[i]) {
                    found = false;
                    break;
                }
            }
            ++index;
            if (found) {
                int i = 0;
                if (index == finalResult.size()) {index = 0;}
                for (Integer item : finalResult.get(index)) {
                    nums[i++] = item;
                }
                break;
            }
        }

    }

    private static ArrayList<Integer> getList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    private static void permutate(ArrayList<ArrayList<Integer>> list, int[] nums, int left, int right) {
        if (left == right) {
            list.add(getList(nums));
        } else {
            for (int i = left; i <= right; i++) {
                swap(nums, left, i);
                permutate(list, nums, left + 1, right);
                swap(nums, i, left);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
    }

    private static void optimisedNextPermutation(int[] nums) {
        int n = nums.length;
        int index1 = -1, index2 = -1;
        for (int i = n - 1; i >= 0; --i) {
            if ((i - 1) >= 0 && (nums[i - 1] < nums[i])) {
                index1 = i - 1;
                break;
            }
        }
        if (index1 > -1) {
            for (int i = n - 1; i >= 0; --i) {
                if (nums[i] > nums[index1]) {
                    index2 = i;
                    break;
                }
            }

            swap(nums, index1, index2);
        }

        reverse(nums, index1 + 1, n - 1);
    }

    // inplace reverse algo
    private static void reverse(int[] ar, int start, int end) {
        int n = end - start + 1;
        for (int i = 0; i < n/2; i++) {
            int currentIndex = i + start;
            int mirrorIndex = n - i - 1 + start;
            swap(ar, currentIndex, mirrorIndex);
        }
    }
}
