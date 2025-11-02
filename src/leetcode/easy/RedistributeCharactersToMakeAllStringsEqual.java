package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual {
    public static void main(String[] args) {
        RedistributeCharactersToMakeAllStringsEqual obj = new RedistributeCharactersToMakeAllStringsEqual();
        System.out.println(obj.makeEqual(new String[]{"abc", "aabc", "bc"}));
        System.out.println(obj.makeEqual(new String[]{"ab", "a"}));
    }

    static class Index {
        int index;
        int count;

        public Index(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public boolean makeEqual(String[] words) {
        int n = words.length;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freqMap.putIfAbsent(c, 0);
                freqMap.put(c, freqMap.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % n != 0) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            if (!(words[i - 1].contains(words[i]) || words[i].contains(words[i - 1]))) {
                return false;
            }
        }
        return true;
//        Map<Character, List<Index>> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            for (char c : words[i].toCharArray()) {
//                map.putIfAbsent(c, new ArrayList<>());
//                map.get(c).add(new Index(i))
//            }
//        }
    }
}
