package leetcode.medium;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
//        System.out.println(obj.canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(obj.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(obj.canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(obj.canPartition(new int[]{1, 2, 3, 5, 17, 6, 14, 12, 6}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        Boolean[] sumDp = new Boolean[target + 1];
        return traverse(0, target, nums, sumDp);
    }

    private boolean traverse(int index, int target, int[] nums, Boolean[] sumDp) {
        if (target == 0) return true;
        if (target < 0 || index >= nums.length) return false;

        if (sumDp[target] != null && sumDp[target]) return sumDp[target];

        boolean include = traverse(index + 1, target - nums[index], nums, sumDp);
        if (include) return sumDp[target] = true;
        boolean exclude = traverse(index + 1, target, nums, sumDp);
        return sumDp[target] = exclude;
    }
}
