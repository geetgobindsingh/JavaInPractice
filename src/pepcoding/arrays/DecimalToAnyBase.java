package pepcoding.arrays;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        System.out.println(getValueInBase(57, 2));
        System.out.println(getValueInBase(57, 3));
        System.out.println(getValueInBase(57, 4));
    }

    private static int getValueInBase(int n, int b) {
        Integer remainder = 0;
        while (n > 0) {
            remainder = remainder * 10 + (n % b);
            n = n / b;
        }
        while (remainder > 0) {
            n = (n * 10) + (remainder % 10);
            remainder = remainder / 10;
        }
        return n;
    }
}
