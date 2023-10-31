package gfg.amazonprep.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.print(find("hello"));
    }

    public static String find(String S) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            String item = String.valueOf(S.charAt(i));
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 0);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            if (map.get(String.valueOf(S.charAt(i))) == 0) {
                return String.valueOf(S.charAt(i));
            }
        }
        return "-1";
    }
}
