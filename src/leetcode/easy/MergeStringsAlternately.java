package leetcode.easy;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pgrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        }
        if (i < m) {
            sb.append(word1.substring(i, m));
        }
        if (j < n) {
            sb.append(word2.substring(j, n));
        }
        return sb.toString();
    }
}
