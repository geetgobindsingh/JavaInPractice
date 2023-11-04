package leetcode.medium;

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
        String input = "yfsrsrpzuya";
        LongestSubStringWithoutRepeatetion object = new LongestSubStringWithoutRepeatetion();
        System.out.println(input);
        System.out.println(object.lengthOfLongestSubstring(input));

    }

    public int lengthOfLongestSubstring(String s) {
        int[] alphabets = new int[256];
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            char cur = s.charAt(right);
            alphabets[cur - ' ']++;
            if (alphabets[cur - ' '] == 1) {
                max = Math.max(max, (right - left + 1));
            } else {
                while (alphabets[cur - ' '] > 1) {
                    char prev = s.charAt(left);
                    alphabets[prev - ' ']--;
                    left++;
                }
            }
            right++;
        }
        return max;
    }
}
