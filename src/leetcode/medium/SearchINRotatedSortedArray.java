package leetcode.medium;

public class SearchINRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{1}, 1));
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[l] < nums[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        int offset = r + 1;
        for (int i = 0; i < nums.length; i++) {
            int index = (i + offset) % nums.length;
            if (nums[index] == target) {
                return i;
            }
        }

        return -1;
    }
}
