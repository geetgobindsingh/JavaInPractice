package practice;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(12, 15)); // 2 * 2 * 3. 3 * 5
        System.out.println(gcd(36, 60));
        System.out.println(gcd(124, 128));
        System.out.println(gcd(34, 153));
        System.out.println(gcd(11, 22));
        System.out.println(gcd(2, 4));
    }

    public static int gcd(int a, int b) {// Worst time complexity
        System.out.println(a + "&" + b + " is:" + gcd2(a, b));
        int result = 1;
        int mul = 2;
        while (((mul < a) || (mul < b))) {
            while (a % mul == 0 && b % mul == 0) {
                result = result * mul;
                a = a / mul;
                b = b / mul;
            }
            mul++;
        }
        return result;
    }

    public static int gcd2(int a, int b) {// best time complexity
        if (a == 0) {
            return b;
        }
        return gcd2(b % a, a);
    }
}
