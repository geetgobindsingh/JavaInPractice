package leetcode.medium;

public class MaximumElementAfterDecreasingAndRearranging {
    public static void main(String[] args) {
        MaximumElementAfterDecreasingAndRearranging obj = new MaximumElementAfterDecreasingAndRearranging();
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
    }


    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) <= 1) {
                continue;
            } else {
               continue;
            }
        }
        return 1;
    }
}
