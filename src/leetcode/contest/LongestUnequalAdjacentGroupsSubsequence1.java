package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequence1 {
    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubsequence1 obj = new LongestUnequalAdjacentGroupsSubsequence1();
        display(obj.getWordsInLongestSubsequence(3, new String[]{"bab", "dab", "cab"}, new int[]{1, 2, 2}));
        display(obj.getWordsInLongestSubsequence(4, new String[]{"a", "b", "c", "d"}, new int[]{1, 2, 3, 4}));
        display(obj.getWordsInLongestSubsequence(3, new String[]{"bdb", "aaa", "ada"}, new int[]{2, 1, 3}));
        display(obj.getWordsInLongestSubsequence(1, new String[]{"abbbb"}, new int[]{1}));
        display(obj.getWordsInLongestSubsequence(2, new String[]{"adbe","acace"}, new int[]{2,2}));
    }

    private static void display(List<String> wordsInLongestSubsequence) {
        for (String w : wordsInLongestSubsequence) {
            System.out.print(w + " ");
        }
        System.out.println();
    }

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        if (groups.length == 1) {
            return Arrays.asList(words);
        }
        List<String> in = new ArrayList<>();
        List<String> ex = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            if (groups[i] != groups[i + 1] && isSafeDistance(words[i], words[i + 1])) {
                ex.clear();
                ex.addAll(in);
                in.add(words[i]);
                in.add(words[i + 1]);
                i++;
            } else {
                if (words[i].length() > words[i + 1].length()) {
                    ex.add(words[i]);
                } else {
                    ex.add(words[i + 1]);
                }
            }
        }
        return in.size() > ex.size() ? in : ex;
    }

    private boolean isSafeDistance(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int distance = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                distance++;
            }
        }
        return distance == 1;
    }

}
