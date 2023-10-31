package leetcode.medium;

import java.util.*;

public class LongestSubStringWithoutRepeatetion {


    /*
    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    //dvdf
    public static void main(String[] args) {
//        String input ="yfsrsrpzuya";
        String input ="yfsrsrpzuya";
        LongestSubStringWithoutRepeatetion object = new LongestSubStringWithoutRepeatetion();
        System.out.println(input);
        System.out.println(object.lengthOfLongestSubstring(input));

    }
    public int lengthOfLongestSubstring(String s) {
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
