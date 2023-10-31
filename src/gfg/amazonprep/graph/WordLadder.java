package gfg.amazonprep.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO: @Difficult @Interesting
public class WordLadder {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.print(ladderLength("hit", "cog", dict));
    }

    public static int ladderLength(String beginWord, String endWord,
                                   List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) return 0;
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
}
