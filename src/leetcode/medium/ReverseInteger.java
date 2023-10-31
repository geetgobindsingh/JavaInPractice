package leetcode.medium;

public class ReverseInteger {
    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(120));
//        System.out.println(reverse(-120));
//        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    public static int reverse(int x) {
        boolean isNegative = (x < 0) ? true : false;
        if (isNegative && x == Integer.MIN_VALUE) {
            return 0;
        }
        if (isNegative) {
            x = x * (-1);
        }
        long result = 0;
        int d = 0;
        int n = x;
        while (n != 0) {
            d = n % 10;
            result = result * 10 + d;
            n = n / 10;
        }
        result = (isNegative) ? (-1 * result) : result;
        try {
            if (result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) {
                return (int) result;
            }
            return 0;
        } catch (Exception ex) {
            return 0;
        }
    }
}
