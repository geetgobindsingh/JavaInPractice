package gfg.amazonprep.strings;

public class ExcelSheetPart1 {
    public static void main(String[] args) {
        System.out.println(excelColumn(1));
        System.out.println(excelColumn(26));
        System.out.println(excelColumn(27));
        System.out.println(excelColumn(28));
        System.out.println(excelColumn(702));
        System.out.println(excelColumn(703));
    }

    public static String excelColumn(int n) {
        if (n <= 26) {
            return getValue(n);
        }
        if (n % 26 == 0) {
            return excelColumn(n / 26 - 1) + getValue(26);
        }
        return excelColumn(n / 26) + getValue(n % 26);
    }

    public static String getValue(int n) {
        return String.valueOf((char) (n + 64));
    }
}
