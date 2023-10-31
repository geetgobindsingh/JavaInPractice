package gfg.amazonprep.strings;

//TODO: @Interesting
public class InterleavedStrings {
    public static void main(String[] args) {
        System.out.println(isInterLeave("xy", "x", "xxy"));
        System.out.println(isInterLeave("aab", "axy", "aaxaby"));
    }

    public static boolean isInterLeave(String a, String b, String c) {
        if (a.length() == 0 && b.length() == 0 && c.length() == 0) {
            return true;
        }
        if (c.length() == 0) {
            return false;
        }
        return (!a.isEmpty() && a.charAt(0) == c.charAt(0) && isInterLeave(a.substring(1), b, c.substring(1))
                || (!b.isEmpty() && b.charAt(0) == c.charAt(0) && isInterLeave(a, b.substring(1), c.substring(1))));
    }
}
