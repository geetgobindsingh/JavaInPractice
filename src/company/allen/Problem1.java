package company.allen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem1 {

    /*
    "abcdabc"

    find maximum possible substring length without repeating any character

    a
    ab
    abc
    abcd -valid 4
    abcda - invalid
    bcda - valid 4
    bcdab - invalid

    return 4
     */

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        System.out.println(obj.findMaxLengthSubStringUsingWindow("abcdabc"));
        System.out.println(obj.findMaxLengthSubStringUsingWindow("abcabcabcabcabc"));
        System.out.println(obj.findMaxLengthSubStringUsingWindow("abcdabxyz"));
        System.out.println(obj.findMaxLengthSubStringUsingWindow("abba"));
    }

    private int findMaxLengthSubStringUsingWindow(String s) { // O(n)
        int n = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) { // is already present
                int prevIndex = map.get(c);
                if (prevIndex >= left) {
                    left = prevIndex + 1;
                }
            }
            map.put(c, right); // update new index of character
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    private int findMaxLengthSubString(String s) { // O(n^2)
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < n; j++) {
                if (!set.add(s.charAt(j))) {
                    break;
                } else {
                    max = Math.max(max, set.size());
                }
            }
        }
        return max;
    }
}









