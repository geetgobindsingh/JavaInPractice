package leetcode.medium;

public class SumOfAbsoluteDifferencesInASortedArray {
    public static void main(String[] args) {
        SumOfAbsoluteDifferencesInASortedArray obj = new SumOfAbsoluteDifferencesInASortedArray();
        for (int i : obj.getSumAbsoluteDifferences(new int[]{2,3,5})) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i : obj.getSumAbsoluteDifferences(new int[]{1,4,6,8,10})) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < n; i++) {
            int item = nums[i];
            rightSum = rightSum - item;

            int totalLeftSum = (item * i) - leftSum;
            int totalRightSum = rightSum - (item * (n - i - 1));
            result[i] = totalLeftSum + totalRightSum;
            leftSum = leftSum + item;
        }
        return result;
    }
    public int[] getSumAbsoluteDifferences1(int[] nums) { // tle O(n^2)
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + Math.abs(nums[j] - nums[i]);
            }
            result[i] = sum;
        }
        return result;
    }
}
