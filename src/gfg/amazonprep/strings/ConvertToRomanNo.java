package gfg.amazonprep.strings;

import java.util.HashMap;

public class ConvertToRomanNo {
    public static void main(String[] args) {
        System.out.print(convertToRoman(9001));
    }

    public static String convertToRoman(int n) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL"); // exception
        map.put(50, "L");
        map.put(90, "XC"); // exception
        map.put(100, "C");
        map.put(400, "CD"); // exception
        map.put(500, "D");
        map.put(900, "CM"); // exception
        map.put(1000, "M");
        map.put(4000, "MG"); // exception
        map.put(5000, "G");
        map.put(9000, "MH"); // exception
        map.put(10000, "H");
        int[] ar = new int[]{10, 40, 50, 90, 100, 400, 500, 900, 1000, 4000, 5000, 9000, 10000};
        String result = "";
        while (n > 10) {
            int i = 0;
            for (; i < ar.length; i++) {
                if (n < ar[i]) {
                    break;
                }
            }
            int count = n / ar[i - 1];
            for (int c = 1; c <= count; c++) {
                result = result + map.get(ar[i - 1]);
            }
            n = n - (count * ar[i - 1]);
        }
        result = result + ((map.get(n) == null) ? "" : map.get(n));
        return result;
    }
}
