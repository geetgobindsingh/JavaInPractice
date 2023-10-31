package striver.arrays;

public class KadanesAlgo {
    //Maximum Subarray Sum
    public static void main(String[] args) {
        int[] ar = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(bruteForce(ar));
        System.out.println(optimisedApproach(ar));
        System.out.println(kadanesAlgo(ar));
    }

    private static int bruteForce(int[] ar) { // O(n^3)
        int n = ar.length;
        int maxSum = 0;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + ar[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }


    private static int optimisedApproach(int[] ar) { // O(n^2)
        int n = ar.length;
        int maxSum = 0;
        for (int i = 0 ; i < n; i++) {
            int sum = ar[i];
            for (int j = i+1 ; j < n; j++) {
                sum = sum + ar[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    private static int kadanesAlgo(int[] ar) { // O(n)
        int n = ar.length;
        int maxSum = 0;
        int sum = 0;
        for (int i = 0 ; i < n; i++) {
            sum = sum + ar[i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
