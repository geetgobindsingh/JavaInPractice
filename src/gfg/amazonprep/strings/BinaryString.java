package gfg.amazonprep.strings;

import java.util.ArrayList;

public class BinaryString {
    public static void main(String[] args) {
        String a = "01101";
        System.out.println(binarySubstring(a.length(), a));
    }

    public static int binarySubstring(int a, String str) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                break;
            }
        }
        if (i == str.length()) {
            return -1;
        }
        int j = i + 1;
        int count = 0;
        while (i < str.length()) {
            if (j < str.length()) {
                if (str.charAt(j) == '1') {
                    count++;
                    i++;
                }
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

}
