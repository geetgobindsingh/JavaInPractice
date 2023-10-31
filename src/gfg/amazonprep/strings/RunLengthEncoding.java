package gfg.amazonprep.strings;

public class RunLengthEncoding {
    public static void main(String[] args) {
        System.out.println(encode("wwwwaaadexxxxxx"));
    }

    public static String encode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            int j = i;
            while (j < str.length() && s == str.charAt(j)) {
                j++;
            }
            result = result + s + (j - i);
            i = j - 1;
        }
        return result;
    }
}
