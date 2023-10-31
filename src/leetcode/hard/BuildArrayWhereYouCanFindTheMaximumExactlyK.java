package leetcode.hard;

public class BuildArrayWhereYouCanFindTheMaximumExactlyK {
    public static void main(String[] args) {
        BuildArrayWhereYouCanFindTheMaximumExactlyK obj = new BuildArrayWhereYouCanFindTheMaximumExactlyK();
        System.out.println(obj.numOfArrays(2, 3, 1));
        System.out.println(obj.numOfArrays(5, 2, 3));
        System.out.println(obj.numOfArrays(9, 1, 1));
        System.out.println(obj.numOfArrays(50, 100, 25));
    }

    public int numOfArrays(int n, int m, int k) {
        if (k > m) {
            return 0;
        }
        int mod = 1000000007;
        double sum = 0;
        for (int i = m; (i - k) >= 0; i--) {
            int remaining = n - k;
            double numberCombinationBeforeK = ncr(i - 1, k - 1);
            double numberPermutationAfterK = Math.pow(i, remaining);
            sum = (sum + (numberCombinationBeforeK * numberPermutationAfterK));
        }
        return (int) (sum % mod);
    }

    public double ncr(int n, int r) {
        double sum = 1;
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return sum;
    }

    public boolean isValid(int[] ar, int max, int k) {
        int searchCost = 0;
        int MAX = Integer.MIN_VALUE;
        for (int i : ar) {
            if (MAX < i) {
                MAX = i;
                searchCost++;
            }
        }
        return MAX == max && searchCost == k;
    }
}
