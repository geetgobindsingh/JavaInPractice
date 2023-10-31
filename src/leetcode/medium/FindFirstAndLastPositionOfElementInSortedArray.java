package leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        obj.displayArray(obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        obj.displayArray(obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        obj.displayArray(obj.searchRange(new int[]{}, 6));
        obj.displayArray(obj.searchRange(new int[]{6}, 6));
        obj.displayArray(obj.searchRange(new int[]{1,2, 6}, 6));
        obj.displayArray(obj.searchRange(new int[]{1,2, 6, 6}, 6));
    }

    private void displayArray(int[] ints) {
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int startIndex = 0;
        int lastIndex = nums.length - 1;
        boolean found = false;
        while (startIndex <= lastIndex) {
            int sum = startIndex + lastIndex;
            int mid = sum / 2;
            if (nums[mid] == target) {
                found = true;
                lastIndex = mid - 1;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            } else {
                lastIndex = mid - 1;
            }
        }
        if (!found) {
            return new int[]{-1, -1};
        }
        lastIndex = nums.length -1;
        int start = startIndex;
        while (start <= lastIndex) {
            int sum = start + lastIndex;
            int mid = sum / 2;
            if (nums[mid] == target) {
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                lastIndex = mid - 1;
            }
        }
        return new int[]{startIndex, lastIndex};
    }

    public int[] searchRange1(int[] nums, int target) {


        int startIndex = 0;
        int lastIndex = nums.length - 1;
        boolean isFound = false;
        while (startIndex < lastIndex) {
            int mid = ((startIndex + lastIndex) / 2);
            if (nums[mid] == target) {
                isFound = true;
                lastIndex = mid;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            } else {
                lastIndex = mid - 1;
            }
        }
        if (!isFound) {
            return new int[]{-1, -1};
        }
        int start = startIndex;
        lastIndex = nums.length - 1;
        while (start < lastIndex) {
            int mid = ((start + lastIndex) / 2) + 1;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                lastIndex = mid - 1;
            }
        }
        return new int[]{startIndex, lastIndex};
    }
}
