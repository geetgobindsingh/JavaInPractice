package pepcoding.arrays;

public class AnyBaseToAnyBase {

    public static void main(String[] args) {
        System.out.println(getValueInBase(111001, 2, 3));
    }

    private static int getValueInBase(int value, int sourceBase, int destBase) {
        Integer remainder = 0;
        while (value > 0) {
            remainder = remainder * sourceBase + (value % destBase);
            value = value / destBase;
        }
        while (remainder > 0) {
            value = (value * 10) + (remainder % 10);
            remainder = remainder / 10;
        }
        return value;
    }
}
