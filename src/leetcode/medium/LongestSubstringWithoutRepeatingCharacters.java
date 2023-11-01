package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(obj.lengthOfLongestSubstring("b")); // 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew")); // 3
    }

    public int lengthOfLongestSubstring(String s) {
        int[] alphabets = new int[26];
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            char cur = s.charAt(right);
            alphabets[cur - 'a']++;
            if (alphabets[cur - 'a'] == 1) {
                max = Math.max(max, (right - left + 1));
            } else {
                while (alphabets[cur - 'a'] > 1) {
                    char prev = s.charAt(left);
                    alphabets[prev - 'a']--;
                    left++;
                }
            }
            right++;
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) { // old

        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 2) {
            return (s.charAt(0) == s.charAt(1)) ? 1 : 2;
        } else {
            int result = 1; // min 1
            Queue<Character> queue = new LinkedList<>();
            for (int index = 0; index < s.length(); ++index) {
                if (queue.contains(s.charAt(index))) {
                    if (queue.size() > result) {
                        result = queue.size();
                    }
                    for (int index_i = 0; index_i < queue.size(); index_i++) {
                        queue.remove();
                        index_i = 0;
                        if (!queue.contains(s.charAt(index))) {
                            queue.add(s.charAt(index));
                            break;
                        }
                    }
                } else {
                    queue.add(s.charAt(index));
                }
            }
            if (queue.size() > result) {
                result = queue.size();
            }
            return result;
        }
    }
}
