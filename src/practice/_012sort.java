package practice;

public class _012sort {
    public static void main(String[] args) {
        for (int i : sort(new int[]{0, 2, 1, 1, 0, 2})) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    private static int[] sort(int[] nums) {
        int n = nums.length - 1;
        int i = 0;
        int k = 0;
        int j = n - 1;
        while (k < j) {
            if (nums[k] == 0) {
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[k] == 1) {
                k++;
            } else {
                swap(nums, j, k);
                j--;
            }
        }
        return nums;
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
