package gfg.amazonprep.strings;

import java.util.HashMap;

public class RomanNumberToInteger {
    public static void main(String[] args) {
        System.out.print(romanToDecimal("MMMDCCXCIV"));
    }

    public static int romanToDecimal(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40); // exception
        map.put("L", 50);
        map.put("XC", 90); // exception
        map.put("C", 100);
        map.put("CD", 400); // exception
        map.put("D", 500);
        map.put("CM", 900); // exception
        map.put("M", 1000);
        map.put("MG", 4000); // exception
        map.put("G", 5000);
        map.put("MH", 9000); // exception
        map.put("H", 10000);

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.substring(i))) {
                result = result + map.get(str.substring(i));
                break;
            } else if ((i + 2) <= str.length() && map.containsKey(str.substring(i, i + 2))) {
                result = result + (map.get(str.substring(i, i + 2)));
                i = i + 1;
            } else if ((i + 1) <= str.length() && str.charAt(i) != str.charAt(i + 1)) {
                result = result + map.get(str.substring(i, i + 1));
            } else {
                int j = i;
                int count = 1;
                for (; j < str.length(); j++) {
                    if (str.charAt(j) == str.charAt(i)) {
                        j++;
                        count++;
                    } else {
                        break;
                    }
                }
                result = result + (count * map.get(str.substring(i, i + 1)));
                i = j - 2;
            }
        }
        return result;
    }
}
