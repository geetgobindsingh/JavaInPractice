package random;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        Object a = -1.444E7;
        Object b = -144;
        Object c = 1.00001111;
        Object d = 1.00001E11;
        Object e = 111111222222333333l;
        String dA = "0.00001";

        System.out.println(getPrettyNumber(a, "%.3f"));
        System.out.println(getPrettyNumber(b, "%.3f"));
        System.out.println(getPrettyNumber(c, "%.3f"));
        System.out.println(getPrettyNumber(d, "%.3f"));
        System.out.println(getPrettyNumber(e, "%.3f"));
        System.out.println(getPrettyNumber(dA, "%.3f"));
    }

    public static String getPrettyNumber(Object input, String decimalLimitFormat) {
        if (input == null) {
            return "";
        }
        if (input instanceof Integer) {
            return (String.format("%d", (Integer) input));
        }
        if (input instanceof Long) {
            return (String.format("%d", (Long) input));
        } else if (input instanceof Double) {
            Double inputInDouble = (Double) input;
            if (inputInDouble == inputInDouble.longValue()) {
                return (String.format("%d", inputInDouble.longValue()));
            } else {
                return (String.format(decimalLimitFormat, inputInDouble));
            }
        } else {
            try {
                return (String.format("%d", (Number) input));
            } catch (Exception ex) {
                return (input.toString());
            }
        }
    }
}
