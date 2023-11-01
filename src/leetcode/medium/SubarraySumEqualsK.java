package leetcode.medium;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(obj.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(obj.subarraySum(new int[]{1}, 0));
        System.out.println(obj.subarraySum(new int[]{-1, -1, 1}, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int s : sum) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
