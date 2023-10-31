package random;

import java.util.Stack;

public class GreaterElementOnLeft {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7};

        int[] result = solutionLeftToRight(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.print("\n");

        result = solutionRightToLeft(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solutionLeftToRight(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); // store value
        stack.push(nums[0]);
        result[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return result;
    }

    private static int[] solutionRightToLeft(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); // store indexes
        stack.push(nums.length - 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int pos = stack.peek();
                result[pos] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pos = stack.peek();
            result[pos] = -1;
            stack.pop();
        }
        return result;
    }
}
