package leetcode.medium;

import java.util.*;
public class BinaryTreesWithFactors {
    public static void main(String[] args) {
        BinaryTreesWithFactors obj = new BinaryTreesWithFactors();
        System.out.println(obj.numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(obj.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = (int) 1e9 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        long[] factors = new long[n];
        Arrays.fill(factors, 1);
        Map<Integer, Integer> idx = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            idx.put(arr[i], i);
        }
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            for (int j = 0; j < i; ++j) {
                int b = arr[j];
                if (a % b == 0) {
                    int c = a / b;
                    if (idx.containsKey(c)) {
                        int k = idx.get(c);
                        factors[i] = (factors[i] + factors[j] * factors[k]) % MOD;
                    }
                }
            }
        }
        long sum = 0;
        for (long f : factors) {
            sum = (sum + f) % MOD;
        }
        return (int) sum;
    }
}
