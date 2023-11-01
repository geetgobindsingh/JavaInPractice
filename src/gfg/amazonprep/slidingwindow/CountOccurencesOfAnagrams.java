package gfg.amazonprep.slidingwindow;

public class CountOccurencesOfAnagrams {
    public static void main(String[] args) {
        CountOccurencesOfAnagrams obj = new CountOccurencesOfAnagrams();
        System.out.println(obj.countOccuranceOfAnagram("forxxorfxdofr", "for"));
        System.out.println(obj.countOccuranceOfAnagram("aabaabaa", "aaba"));
    }

    private int countOccuranceOfAnagram(String text, String pattern) {
        int[] alphabets = new int[26];
        for (int i = 0; i < pattern.length(); i++) {
            alphabets[pattern.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int left = 0, right = 0; right < text.length(); right++) {
            alphabets[text.charAt(right) - 'a']--;

            if ((right - left + 1) == pattern.length()) {
                if (allZero(alphabets, pattern)) {
                    count++;
                }
                alphabets[text.charAt(left) - 'a']++;
                left++;
            }
        }
        return count;
    }

    private boolean allZero(int[] alphabets, String pattern) {
        boolean result = true;
        for (int i = 0; i < pattern.length(); i++) {
            if (alphabets[pattern.charAt(i) - 'a'] != 0) return false;
        }
        return result;
    }


}
