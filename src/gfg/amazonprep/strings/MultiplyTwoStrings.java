package gfg.amazonprep.strings;

public class MultiplyTwoStrings {
    public static void main(String[] args) {
        System.out.print(multiply("33", "2"));
    }

    public static String multiply(String a, String b) { // fastest but not the required answer
        return new java.math.BigInteger(a).multiply(new java.math.BigInteger(b)).toString();
    }
}
