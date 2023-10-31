package gfg.amazonprep.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UniqueWordsFromTwoSentences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            for (String o : getUniqueWordsInLexicalOrder(br.readLine(), br.readLine())) {
                System.out.print(o + " ");
            }
            System.out.print("\n");
        }
    }

    public static List<String> getUniqueWordsInLexicalOrder(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : A.split(" ")) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (String b : B.split(" ")) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        TreeSet<String> treeSet = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                treeSet.add(entry.getKey());
            }
        }

        return new ArrayList<>(treeSet);
    }

}
