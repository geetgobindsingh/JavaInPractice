package leetcode.easy;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings obj = new GreatestCommonDivisorOfStrings();
        System.out.println(obj.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(obj.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(obj.gcdOfStrings("DABABAB", "ABAB"));
        System.out.println(obj.gcdOfStrings("ABCDEF", "ABC"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) return "";
        if (!str1.isEmpty() && !str2.isEmpty() && str1.charAt(0) != str2.charAt(0)) return "";
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int len = gcd(str1.length(), str2.length());
        return str1.substring(0, len);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
