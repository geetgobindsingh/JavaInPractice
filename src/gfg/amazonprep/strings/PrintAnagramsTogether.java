package gfg.amazonprep.strings;

import java.util.*;

public class PrintAnagramsTogether {
    public static void main(String[] args) {
        for (List<String> list : Anagrams(new String[]{"abc", "cbd", "dog", "god", "cba"})) { // Exception WOW
//        for (List<String> list : Anagrams(new String[]{"baoyal", "bmmdgq"})) { // Exception WOW
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println("");
        }
    }

    public static List<List<String>> Anagrams(String[] string_list) {
        String[] temp = new String[string_list.length];
        for (int i = 0; i < string_list.length; i++) {
            char[] ar = string_list[i].toCharArray();
            Arrays.sort(ar);
            temp[i] = new String(ar);
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < string_list.length; i++) {
            List<String> list = new ArrayList<>();
            if (map.containsKey(temp[i])) {
                list = map.get(temp[i]);
            }
            list.add(string_list[i]);
            map.put(temp[i], list);
        }
        return new ArrayList<>(map.values());
    }
}
