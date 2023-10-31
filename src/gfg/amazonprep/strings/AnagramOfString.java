package gfg.amazonprep.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramOfString {
    public static void main(String[] args) {
        System.out.print(remAnagrams("basgadhbfgvhads", "sjdhgvbjdsbhvbvd"));
//        System.out.print(remAnagrams("adhbfgvhads", "jdhgvjdsbhvbvd"));
    }

    public static int remAnagrams(String s, String s1) {
        if (s.length() > s1.length()) {
            String temp = s;
            s = s1;
            s1 = temp;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) - 1);
            } else {
                map.put(s1.charAt(i), -1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            count += Math.abs(e.getValue());
        }
        return count;
    }
}
