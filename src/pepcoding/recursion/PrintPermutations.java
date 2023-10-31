package pepcoding.recursion;

import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        printPermutations(input, "");
    }

    private static void printPermutations(String input, String ans) {
        int l = input.length();
        if (l == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < l; i++) {
            char ch = input.charAt(i);
            printPermutations(input.replace(String.valueOf(ch), ""), ans + ch);
        }
    }
}
