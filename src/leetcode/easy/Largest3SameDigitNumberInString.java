package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Largest3SameDigitNumberInString {
    public static void main(String[] args) {
        Largest3SameDigitNumberInString obj = new Largest3SameDigitNumberInString();
        System.out.println(obj.largestGoodInteger("6777133339"));
        System.out.println(obj.largestGoodInteger("2300019"));
    }

    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String ret = String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
            if (num.contains(ret)) {
                return ret;
            }
        }
        return "";
    }
    public String largestGoodInteger1(String num) {
        int n = num.length();
        List<String> goodIntegers = new ArrayList<>();
        for (int i = 1; i < (n - 1); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i + 1)) {
                goodIntegers.add(num.substring(i - 1, i + 2));
            }
        }
        if (goodIntegers.isEmpty()) {
            return "";
        }
        int max = 0;
        for (String s : goodIntegers) {
            max = Math.max(max, Integer.parseInt(s));
        }
        if (max == 0) {
            return "000";
        }
        return String.valueOf(max);
    }
}
