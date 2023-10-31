package leetcode.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{1,1};
        System.out.print(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        printArray(heights);
        int[] leftMin = new int[heights.length];
        updateLeftMin(leftMin, heights);
        printArray(leftMin);
        int[] rightMin = new int[heights.length];
        updateRightMin(rightMin, heights);
        printArray(rightMin);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (heights[i] * (rightMin[i] - leftMin[i] - 1)));
        }
        return max;
    }

    public static void printArray(int[] ar) {
        for (int a : ar) {
            System.out.print(a + " ");
        }
        System.out.print("\n");
    }

    // 2 1 5
    // -1 -1 1 L
    // 1 3 3 R
    private static void updateLeftMin(int[] leftMin, int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        leftMin[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftMin[i] = -1;
            } else {
                leftMin[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    private static void updateRightMin(int[] rightMin, int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length - 1);
        rightMin[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightMin[i] = heights.length;
            } else {
                rightMin[i] = stack.peek();
            }
            stack.push(i);
        }
    }
}
