package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters obj = new FindWordsThatCanBeFormedByCharacters();
        System.out.println(obj.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(obj.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        for (int i = 0; i < chars.length(); ++i) {
            ++cnt[chars.charAt(i) - 'a'];
        }
        int ans = 0;
        for (String w : words) {
            int[] wc = new int[26];
            boolean ok = true;
            for (int i = 0; i < w.length(); ++i) {
                int j = w.charAt(i) - 'a';
                if (++wc[j] > cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans += w.length();
            }
        }
        return ans;
    }
}
