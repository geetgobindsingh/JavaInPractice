package leetcode.easy;

public class ClimbSteps {
    public static void main(String[] args) {
        System.out.println(new ClimbSteps().climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
