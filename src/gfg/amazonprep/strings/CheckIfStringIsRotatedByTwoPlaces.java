package gfg.amazonprep.strings;

public class CheckIfStringIsRotatedByTwoPlaces {
    public static void main(String[] args) {
        System.out.println(isRotated("amazon", "azonam"));
    }

    public static boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int length = s2.length();
        String clockWise = s2.substring(2) + s2.substring(0, 2);
        String anticlockWise = s2.substring(length - 2) + s2.substring(0, length - 2);
        return (clockWise.equalsIgnoreCase(s1) || anticlockWise.equalsIgnoreCase(s1));
    }

}
