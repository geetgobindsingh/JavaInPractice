package leetcode.medium;

public class Pow {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 5));
        System.out.println(powWithRecursion(2, -5));
        System.out.println(Math.pow(0.00001, 2147483647));
        System.out.println(powWithRecursion(0.00001, 2147483647));
        System.out.println(Math.pow(8.95371, -1));
        System.out.println(powWithRecursion(8.95371, -1));
        System.out.println(Math.pow(1.00000, -2147483648));
        System.out.println(powWithRecursion(1.00000, -214748364));
    }


    public static double powWithRecursion(double x, int n) {
        boolean carry = (Integer.MIN_VALUE == n);
        if (n == 0) {
            return 1;
        }
        boolean isNegative = n < 0;
        if (isNegative) {
            n = (n + (carry ? 1 : 0)) * -1;
        }
        if (n == 1) {
            if (isNegative) {
                return 1 / x;
            }
            return x;
        }

        double result = powR(x, n);

        if (isNegative) {
            return 1 / (result * (carry ? x : 1));
        }
        return result * (carry ? x : 1);
    }

    public static double powR(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        boolean isEven = n % 2 == 0;
        if (isEven) {
            return powR(x * x, n / 2);
        } else {
            return x * powR(x * x, (n - 1) / 2);
        }
    }

    // throwing OOM using Memory
    public static double powWithMemory(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean isNegative = n < 0;
        if (isNegative) {
            n = n * -1;
        }
        if (n == 1) {
            return x;
        }
        double ar[] = new double[n];
        ar[0] = 1;
        ar[1] = x;
        for (int i = 2; i < n; i++) {
            ar[i] = x * ar[i - 1];
        }
        if (isNegative) {
            return 1 / (x * ar[n - 1]);
        }
        return (x * ar[n - 1]);
    }
}
