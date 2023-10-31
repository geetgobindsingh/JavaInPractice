package random;

import java.util.Stack;

public class GreaterElementOnRight {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7};

        int[] result = solutionRightToLeft(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.print("\n");

        result = solutionLeftToRight(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solutionRightToLeft(int[] nums) { // O(N)
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = result.length - 1; i >= 0; --i) {
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (top < nums[i]) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return result;
    }

    private static int[] solutionLeftToRight(int[] nums) { // O(N^2)
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); // store indexes
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
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
