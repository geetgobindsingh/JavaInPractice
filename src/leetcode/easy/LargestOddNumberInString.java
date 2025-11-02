package leetcode.easy;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

public class LargestOddNumberInString {
    public static void main(String[] args) {
        LargestOddNumberInString obj = new LargestOddNumberInString();
        System.out.println(obj.largestOddNumber("52"));
        System.out.println(obj.largestOddNumber("4206"));
        System.out.println(obj.largestOddNumber("35427"));
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Integer.parseInt(num.substring(i, i + 1)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
