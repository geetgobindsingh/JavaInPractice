package gfg.amazonprep.strings;

public class ExcelSheetPart2 {
    public static void main(String[] args) {
        System.out.println(excelColumnNumber("A"));
        System.out.println(excelColumnNumber("Z"));
        System.out.println(excelColumnNumber("AA"));
        System.out.println(excelColumnNumber("ZZ"));
        System.out.println(excelColumnNumber("AAA"));
    }

    public static int excelColumnNumber(String s) {
        if (s.length() == 1) {
            return (getValue(s.charAt(0), s.length() - 1));
        }
        return (getValue(s.charAt(0), s.length() - 1)) + excelColumnNumber(s.substring(1));
    }

    public static int getValue(char c, int tens) {
        return ((int) c - 64) * (int) Math.pow(26, tens);
    }
}
