package leetcode.medium;

public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero obj = new MinimumOperationsToReduceXToZero();
        System.out.println(obj.minOperations(new int[]{3,2,20,1,1,3}, 10));
    }

    public int minOperations(int[] nums, int x) {
        int l = 0;
        int r = nums.length - 1;
        int steps = 0;
        while (l < r) {
            int left = nums[l];
            int right = nums[r];
            if (left == right && left <= x) {
                int rightOfLeft = nums[l + 1];
                int leftOfRight = nums[r - 1];
                if (rightOfLeft < leftOfRight) {
                    x = x - right;
                    steps++;
                    if (x == 0) {
                        return steps;
                    } else if (x < 0) {
                        break;
                    }
                    r--;
                } else {
                    x = x - left;
                    steps++;
                    if (x == 0) {
                        return steps;
                    } else if (x < 0) {
                        break;
                    }
                    l++;
                }
            } else {
                if (left < right && right <= x) {
                    x = x - right;
                    steps++;
                    if (x == 0) {
                        return steps;
                    } else if (x < 0) {
                        break;
                    }
                    r--;
                } else if (left <= x) {
                    x = x - left;
                    steps++;
                    if (x == 0) {
                        return steps;
                    } else if (x < 0) {
                        break;
                    }
                    l++;
                } else {
                    x = x - right;
                    steps++;
                    if (x == 0) {
                        return steps;
                    } else if (x < 0) {
                        break;
                    }
                    r--;
                }
            }
        }
        return -1;
    }
}
