package gfg.amazonprep.strings;

import java.util.ArrayList;

public class ReverseWordsInAGivenString {
    public static void main(String[] args) {
        System.out.println(reverseWords("i.like.this.program.very.much"));
    }

    public static String reverseWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '.') {
                list.add(s.substring(i, j));
                i = j + 1;
            } else if (j == (s.length() - 1)) {
                list.add(s.substring(i, j + 1));
            }
        }
        String result = "";
        for (i = list.size() - 1; i >= 0; i--) {
            result = result + list.get(i) + ((i == 0) ? "" : ".");
        }
        return result;
    }
}
