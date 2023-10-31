package leetcode.medium;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
    }

    public static int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        max = Math.max(max, count);

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static boolean isVowel(char cr) {
        if (cr == 97 || cr == 101 || cr == 105 || cr == 111 || cr == 117) {
            return true;
        }
        return false;
    }
}
