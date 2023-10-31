package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(obj.minWindow("a", "a"));
//        System.out.println(obj.minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> freg = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            freg.putIfAbsent(key, freg.getOrDefault(key, 0) + 1);
        }
        Deque<Integer> q = new ArrayDeque<>();

        String minString = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freg.containsKey(c)) {
                if (freg.get(c) == 0) {
                    if (q.size() > 0 && s.charAt(q.peekFirst()) == c) {
                        q.pollFirst();
                        q.offerFirst(i);
                    }
                } else {
                    q.offerLast(i);
                    freg.put(c, freg.get(c) - 1);
                }
            }

            if (q.size() == t.length() && !q.isEmpty()) {
                String substring = s.substring(q.peekFirst(), q.peekLast());
                if (minString.equals("")) {
                    minString = substring;
                } else if (substring.length() < minString.length()) {
                    minString = substring;
                }
            }
        }

        return minString;
    }
}
