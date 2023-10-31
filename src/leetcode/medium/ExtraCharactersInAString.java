package leetcode.medium;

import java.util.Arrays;

public class ExtraCharactersInAString {
    public static void main(String[] args) {
        ExtraCharactersInAString obj = new ExtraCharactersInAString();
//        System.out.println(obj.minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
//        System.out.println(obj.minExtraChar("sayhelloworld", new String[]{"hello","world"}));
        System.out.println(obj.minExtraChar("dwmodizxvvbosxxw", new String[]{"ox", "lb", "diz", "gu", "v", "ksv",
                "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"}));
    }

    public int minExtraChar(String s, String[] dictionary) {
        Arrays.sort(dictionary);
        StringBuilder sb = new StringBuilder(s);
        for (int i = dictionary.length - 1; i >= 0; i--) {
            if (s.contains(dictionary[i])) {
                int j = s.indexOf(dictionary[i]);
                sb.delete(j, j + dictionary[i].length());
            }
            s = sb.toString();
        }
        return sb.length();
    }
}
