package leetcode.contest;

public class DivisibleandNondivisibleSumsDifference {
    public static void main(String[] args) {
        DivisibleandNondivisibleSumsDifference obj = new DivisibleandNondivisibleSumsDifference();
        System.out.println(obj.differenceOfSums(10,3));
        System.out.println(obj.differenceOfSums(5,6));
        System.out.println(obj.differenceOfSums(5,1));
    }

    public int differenceOfSums(int n, int m) {
        int divisibleSum = 0;
        int maxSum = (n * (n + 1)) / 2;
        for (int i = 1; i <= n; ++i) {
            if (i % m == 0) {
                divisibleSum = divisibleSum + i;
            }
        }
        int nonDivisibleSum = maxSum - divisibleSum;
        return nonDivisibleSum - divisibleSum;
    }
}
