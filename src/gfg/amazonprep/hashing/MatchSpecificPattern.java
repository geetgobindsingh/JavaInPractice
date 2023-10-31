package gfg.amazonprep.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchSpecificPattern {
    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>();
        dict.add("abb");
        dict.add("abc");
        dict.add("xyz");
        for (String s : findMatchedWords(dict, "xyy")) {
            System.out.print(s + " ");
        }
    }

    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern) {
        ArrayList<String> result = new ArrayList<>();
        int patternKey = getPatternKey(pattern);
        for (String s : dict) {
            if (patternKey == getPatternKey(s)) {
                result.add(s);
            }
        }
        return result;
    }

    private static int getPatternKey(String pattern) {
        int count = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                result = result * 10 + map.get(pattern.charAt(i));
            } else {
                result = result * 10 + count;
                map.put(pattern.charAt(i), count++);
            }
        }
        return result;
    }
}
