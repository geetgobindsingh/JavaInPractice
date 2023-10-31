package gfg.amazonprep.stack;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        System.out.println(maxArea(matrix, matrix.length, matrix[0].length));

        matrix = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
        };
        System.out.println(maxArea(matrix, matrix.length, matrix[0].length));
    }

    public static int maxArea(int M[][], int n, int m) {
        int max = Integer.MIN_VALUE;
        int ar[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[j] = (M[i][j] == 0) ? 0 : ar[j] + M[i][j];
            }
            max = Math.max(max, getMaxArea(ar));
        }
        return max;
    }


    public static void printArray(int[] ar) {
        for (int a : ar) {
            System.out.print(a + " ");
        }
        System.out.print("\n");
    }

    private static int getMaxArea(int[] heights) {
        int[] leftMin = new int[heights.length];
        updateLeftMin(leftMin, heights);
        int[] rightMin = new int[heights.length];
        updateRightMin(rightMin, heights);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (heights[i] * (rightMin[i] - leftMin[i] - 1)));
        }
        return max;
    }

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
