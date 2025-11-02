package leetcode.easy;

import java.util.*;

public class LargestSubstringBetweenTwoEqualCharacters {
    public static void main(String[] args) {
        LargestSubstringBetweenTwoEqualCharacters obj = new LargestSubstringBetweenTwoEqualCharacters();
        System.out.println(obj.maxLengthBetweenEqualCharacters("aba"));
        System.out.println(obj.maxLengthBetweenEqualCharacters("abaaa"));
        System.out.println(obj.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(obj.maxLengthBetweenEqualCharacters("cbzxy"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), new ArrayList<>());
            map.get(s.charAt(i)).add(i);
        }
        int ans = -1;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                ans = Math.max(ans, entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0) - 1);
            }
        }
        return ans;
    }
}
