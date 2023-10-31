package leetcode.medium;

import java.util.*;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        RepeatedDNASequences obj = new RepeatedDNASequences();
//        System.out.println(obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
//        System.out.println(obj.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(obj.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0, j = 10; j <= s.length(); j++, i++) {
            String ss = s.substring(i, j);
            if (!set.add(ss)) {
                result.add(ss);
            }
        }
        return new ArrayList<>(result);
    }
}
