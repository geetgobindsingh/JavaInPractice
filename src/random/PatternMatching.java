package random;

import java.util.regex.Pattern;

public class PatternMatching {

    private static String URL_PATTERN = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    public static void main(String[] args) {
//        System.out.println(stringContainsOneSpecialCharacter("[]"));
//        System.out.println(stringContainsOneSpecialCharacter("$"));
        System.out.println(isURL("www"));
        System.out.println(isURL("https"));
        System.out.println(isURL("https://www.comerve"));
        System.out.println(isURL("https://www.youtube.com"));
        System.out.println(isURL("https://youtube.org"));
    }

    private static boolean isURL(String s) {
        return Pattern.compile(URL_PATTERN).matcher(s).find();
    }

    private static boolean stringContainsOneSpecialCharacter(String s) {
        return Pattern.compile("[@#$%\\[\\]^&+=!]").matcher(s).find();
    }
}
