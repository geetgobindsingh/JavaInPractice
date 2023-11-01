package leetcode.hard;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(obj.minWindow("a", "a"));
        System.out.println(obj.minWindow("a", "aa"));
        System.out.println(obj.minWindow("ab", "b"));
    }

    public String minWindow(String s, String t) {
        int[] alphabets = new int[26 + 26];
        if (t.length() > s.length()) return "";
        int n = s.length();
        for (int i = 0; i < t.length(); i++) {
            alphabets[getIndex(t.charAt(i))]++;
        }
        int left = 0;
        int right = 0;
        String substring = null;
        while (right < n) {
            char cur = s.charAt(right);
            alphabets[getIndex(cur)]--;
            int status = checkAllMarked(alphabets, t);
            
            if (status == -1) {
                while (checkAllMarked(alphabets, t) <= 0) {
                    alphabets[getIndex(s.charAt(left))]++;
                    left++;
                }
                left--;
                alphabets[getIndex(s.charAt(left))]--;
                status = checkAllMarked(alphabets, t);
            }
            if (status == 0) {
                if (substring == null || substring.length() > (right - left + 1)) {
                    substring = s.substring(left, right + 1);
                }
            }
            right++;
        }
        if (substring == null) return "";
        return substring;
    }

    private int getIndex(char c) {
        if (c >= 65 && c <= 90) {
            return c - 65;
        } else {
            return c - 97 + 26;
        }
    }

    private int checkAllMarked(int[] alphabets, String t) {
        boolean flag = false;
        for (int i = 0; i < t.length(); i++) {
            if (alphabets[getIndex(t.charAt(i))] == 0) {
                continue;
            }
            if (alphabets[getIndex(t.charAt(i))] < 0) return -1;
            if (alphabets[getIndex(t.charAt(i))] > 0) {
                flag = true;
            }
        }
        return flag ? 1 : 0;
    }
}
