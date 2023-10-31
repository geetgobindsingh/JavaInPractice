package leetcode.medium;

public class Atoi {
    public static void main(String[] args) {
        Atoi obj = new Atoi();
        System.out.println(obj.myAtoi("   -42 asas asas    "));
        System.out.println(obj.myAtoi("   -sas asas    "));
        System.out.println(obj.myAtoi("   -+12    "));
        System.out.println(obj.myAtoi("  0000000000012345678"));
        System.out.println(obj.myAtoi("  -0000000000012345678"));
    }

    public int myAtoi(String s) {
        int result = 0;
        s = s.trim();
        int multiplier = 1;
        if (s.charAt(0) == '-') {
            multiplier = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        int i = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        s = s.substring(0, i);

        i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        s = s.substring(i);

        if (s.length() == 0) {
            return 0;
        } else if (s.length() > String.valueOf(Integer.MAX_VALUE).length()) {
            return (multiplier == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        try {
            result = Integer.parseInt(s);
        } catch (Exception e) {
            return (multiplier == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return multiplier * result;
    }

}
