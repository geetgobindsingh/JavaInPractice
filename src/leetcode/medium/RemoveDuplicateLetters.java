package leetcode.medium;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
        System.out.println(obj.removeDuplicateLetters("bcabc"));
        System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) { // not able to understand it
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        Deque<Character> stk = new ArrayDeque<>();
        int mask = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (((mask >> (c - 'a')) & 1) == 1) {
                continue;
            }
            while (!stk.isEmpty() && stk.peek() > c && last[stk.peek() - 'a'] > i) {
                mask ^= 1 << (stk.pop() - 'a');
            }
            stk.push(c);
            mask |= 1 << (c - 'a');
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stk) {
            ans.append(c);
        }
        return ans.reverse().toString();
    }
}
