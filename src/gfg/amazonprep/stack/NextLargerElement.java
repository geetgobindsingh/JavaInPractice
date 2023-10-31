package gfg.amazonprep.stack;

import java.util.Stack;

public class NextLargerElement {
    public static void main(String[] args) {
        long ar[] = new long[]{1, 3, 2, 4};
//        long ar[] = new long[]{6, 8, 0, 1, 3};
//        long ar[] = new long[]{10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6};
//        long ar[] = new long[]{10, 9, 8 , 7 , 6  , 6 , 5};
        for (long i : nextLargerElement(ar, ar.length)) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (long i : nextSmallerElement(ar, ar.length)) {
            System.out.print(i + " ");
        }
    }

    public static long[] nextSmallerElement(long[] arr, int n) { // left to right
        long result[] = new long[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static long[] nextLargerElement(long[] arr, int n) { // left to right
        long result[] = new long[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static long[] nextLargerElement1(long[] arr, int n) { // right to left
        long result[] = new long[n];
        Stack<Long> stack = new Stack<>();
        long max = Integer.MIN_VALUE;
        for (int index = (n - 1); index >= 0; index--) {
            if (stack.isEmpty()) {
                max = arr[index];
                result[index] = -1;
                stack.push(arr[index]);
            } else {
                long top = stack.peek();
                if (max < arr[index]) {
                    while (!stack.isEmpty()) {
                        stack.pop();
                    }
                    max = arr[index];
                    result[index] = -1;
                    stack.push(arr[index]);
                } else if (top > arr[index]) {
                    result[index] = top;
                    stack.push(arr[index]);
                } else {
                    while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                        stack.pop();
                    }
                    result[index] = stack.isEmpty() ? -1 : stack.peek();
                    stack.push(arr[index]);
                }
            }
        }
        return result;
    }
}
