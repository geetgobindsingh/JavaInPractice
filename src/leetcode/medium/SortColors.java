package leetcode.medium;

import helper.ArrayUtil;

//https://leetcode.com/problems/sort-colors/description/
public class SortColors {
    public static void main(String[] args) {
        int[] a = new int[]{2, 0, 2, 1, 1, 0};
        new Solution().sortColors(a);
        ArrayUtil.printArray(a);
    }

    static class Solution {

        public static int sortAnB(int[] ar, int i, int j, int elementAtRightMost) {
            while (i < j) {
                while (i < ar.length - 1 && ar[i] != elementAtRightMost) {
                    i++;
                }
                while (j > 0 && ar[j] == elementAtRightMost) {
                    j--;
                }
                if (i < j) {
                    ArrayUtil.swap(ar, i, j);
                }
            }
            return j;
        }

        // 1 pass
        public void sortColors(int[] nums) {
            int low = 0;
            int mid = 0;
            int high = nums.length - 1;
            while (mid <= high) {
                if (nums[mid] == 0) {
                    ArrayUtil.swap(nums, low, mid);
                    low++;
                    mid++;
                } else if (nums[mid] == 1) {
                    mid++;
                } else if (nums[mid] == 2) {
                    ArrayUtil.swap(nums, mid, high);
                    high--;
                }
            }
        }

        // 2 pass
        public void sortColors2Pass(int[] nums) {
            int high = sortAnB(nums, 0, nums.length - 1, 2);
            sortAnB(nums, 0, high, 1);
        }
    }
}
