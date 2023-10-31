package gfg.amazonprep.strings;

import java.util.*;

public class MostFrequentNonBadWord {
    public static void main(String[] args) {
        String paragraph = "Geeks like to code. The code on GEEKS for GEEKS is curated by in-office geeks.";
        List<String> taboo = new ArrayList<>();
        taboo.add("Geeks");
        System.out.println(MostFrequent(paragraph, taboo));
    }

    public static String MostFrequent(String paragraph, List<String> taboo) {
        paragraph = paragraph.replaceAll("\\p{Punct}", "").toLowerCase();
        String[] words = paragraph.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String tabu : taboo) {
            set.add(tabu.toLowerCase());
        }
        for (String word : words) {
            if (!set.contains(word)) {
                if (!map.containsKey(word)) {
                    map.put(word, 0);
                }
                map.put(word, map.get(word) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        String result = "";
        for (String word : map.keySet()) {
            int count = map.get(word);
            if (max < count) {
                max = count;
                result = word;
            }
        }
        return result;
    }
}
