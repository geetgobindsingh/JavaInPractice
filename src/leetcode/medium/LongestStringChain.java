package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain obj = new LongestStringChain();
        System.out.println(obj.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(obj.longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
        System.out.println(obj.longestStrChain(new String[]{"abcd", "dbqca"}));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int x = 1;
            for (int i = 0; i < word.length(); ++i) {
                String pre = word.substring(0, i) + word.substring(i + 1);
                x = Math.max(x, map.getOrDefault(pre, 0) + 1);
            }
            map.put(word, x);
            res = Math.max(res, x);
        }
        return res;
    }

    public int longestStrChain2(String[] words) { // using LIS
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        int omax = 0;
        for (int i = 0; i < words.length; ++i) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (isNextInChain(words[j], words[i])) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }

    public boolean isNextInChain(String pre, String next) {
        int k = 0;
        for (int i = 0; i < next.length(); i++) {
            if (k < pre.length() && pre.charAt(k) == next.charAt(i)) {
                k++;
            } else if (k == pre.length()) {
                break;
            }
        }
        if (k == pre.length()) {
            return pre.length() == (next.length() - 1);
        }
        return false;
    }
}
