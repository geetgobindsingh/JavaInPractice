package pepcoding.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encoding {
    //123 -> abc, aw, lc
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        printEncodings(input, "");
    }

    private static String getString(int i) {
        if (i > 0 && i < 27) {
            return String.valueOf((char) (96 + i));
        }
        return "";
    }

    private static void printEncodings(String input, String ans) {
//        int l = input.length();
//        if (l == 0 ) {
//            System.out.println("Ans: " + ans);
//            return;
//        }
//        if (l == 1) {
//            System.out.println("Ans: " + ans + getString(Integer.parseInt(input)));
//            return;
//        }
//
//        String subString1 = input.substring(0, 1);
//        String subString2 = input.substring(0, 2);
//        String firstEncoding = getString(Integer.parseInt(subString1));
//        String secondEncoding = getString(Integer.parseInt(subString2));
//        printEncodings(input.substring(1), ans + firstEncoding);
//        printEncodings(input.substring(2), ans + secondEncoding);
    }
}
