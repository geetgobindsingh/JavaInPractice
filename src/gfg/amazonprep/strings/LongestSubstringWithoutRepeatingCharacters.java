package gfg.amazonprep.strings;

import java.util.HashSet;
import java.util.Set;

//TODO: @Interesting @Difficult
// Typical Two Pointer and Sliding window problem
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("geeksforgeeks" + " " + SubsequenceLength("geeksforgeeks"));
        System.out.println("aab" + " " + SubsequenceLength("aab"));
        System.out.println("abbcdb" + " " + SubsequenceLength("abbcdb"));
        System.out.println("bbb" + " " + SubsequenceLength("bbb"));
        System.out.println("dvdf" + " " + SubsequenceLength("dvdf"));
        System.out.println("abcabcbb" + " " + SubsequenceLength("abcabcbb"));
        System.out.println("abdefgabef" + " " + SubsequenceLength("abdefgabef"));
    }

    public static int SubsequenceLength(String s) { // 2 ms
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int SubsequenceLength2(String s) { // 6 ms TLE
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(left++));
                }
            }
            set.add(s.charAt(i));
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static int SubsequenceLength1(String s) { // right submission TLE 1.50sec
        Set<String> set = new HashSet<>();
        getRepeatedCharacterSeparatedStringList(s, set);
        getRepeatedCharacterSeparatedStringListReverse(s, set);
        int max = Integer.MIN_VALUE;
        for (String ss : set) {
            max = Integer.max(max, ss.length());
        }
        return max;
    }

    private static void getRepeatedCharacterSeparatedStringList(String input, Set<String> set1) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < (input.length()); i++) {
            if (set.contains(input.charAt(i))) {
                set1.add(input.substring(0, i));
                getRepeatedCharacterSeparatedStringList(input.substring(i), set1);
                return;
            }
            set.add(input.charAt(i));
        }
        set1.add(input);
    }

    private static void getRepeatedCharacterSeparatedStringListReverse(String input, Set<String> set1) {
        Set<Character> set = new HashSet<>();
        for (int i = input.length() - 1; i >= 0; i--) {
            if (set.contains(input.charAt(i))) {
                set1.add(input.substring(i + 1));
                getRepeatedCharacterSeparatedStringListReverse(input.substring(0, i), set1);
                return;
            }
            set.add(input.charAt(i));
        }
        set1.add(input);
    }
}
