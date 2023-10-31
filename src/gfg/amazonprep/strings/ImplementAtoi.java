package gfg.amazonprep.strings;

public class ImplementAtoi {
    public static void main(String[] args) {
        System.out.println(atoi("012039"));
    }

    public static int atoi(String str) {
        int result = 0;
        boolean minus = false;
        int i = 0;
        if (str.startsWith("-")) {
            minus = true;
            i++;
        }
        for (; i < str.length(); i++) {
            if (48 <= str.charAt(i) && str.charAt(i) <= 57) {
                result = (result * 10) + ((int) str.charAt(i) - 48);
            } else {
                return -1;
            }
        }
        return (minus ? -1 : 1) * result;
    }

    public static int atoi2(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

}
