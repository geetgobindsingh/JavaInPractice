package leetcode.hard;

import java.util.HashMap;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        PalindromePartitioningII obj = new PalindromePartitioningII();
        System.out.println(obj.minCut("abccbc"));
        System.out.println(obj.minCut("aab"));
        System.out.println(obj.minCut("ab"));
        System.out.println(obj.minCut("bab"));
        System.out.println(obj.minCut("a"));
        System.out.println(obj.minCut("b"));
    }

    public int minCut(String s) {
        return minCuts(s, new HashMap<>());
    }

    private int minCuts(String s, HashMap<String, Integer> dp) {
        if (s.length() <= 1) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 0;
        }
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < s.length(); j++) {
            min = Math.min(minCuts(s.substring(0, j), dp) + minCuts(s.substring(j), dp) + 1, min);
        }
        dp.put(s, min);
        return dp.get(s);
    }

    private int minCuts2(String s) { //tle
        if (s.length() <= 1) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < s.length(); j++) {
            min = Math.min(minCuts2(s.substring(0, j)) + minCuts2(s.substring(j)) + 1, min);
        }
        return min;
    }

    private boolean isPalindrome(String s) {
        int l = s.length() / 2;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
