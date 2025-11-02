package leetcode.medium;

import java.util.*;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        SumOfSubarrayMinimums obj = new SumOfSubarrayMinimums();
        System.out.println(obj.sumSubarrayMins(new int[]{3,1,2,4}));
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        int mod = (int) 1e9 + 7;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += ((long) (i - left[i]) * (right[i] - i) % mod) * (arr[i] % mod);
            ans %= mod;
        }
        return (int) ans;
    }
}
