package leetcode.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

public class ValidPalindrome {
    public static void main(String[] args) throws IOException {
        /*
        Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

        Note: For the purpose of this problem, we define empty string as valid palindrome.

        Example 1:

        Input: "A man, a plan, a canal: Panama"
        Output: true
        Example 2:

        Input: "race a car"
        Output: false
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Sentence: ");
        String input = " a ";
        System.out.print(input);
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println();
        System.out.println(validPalindrome.isValidPalindrome(input));
    }

    private boolean isValidPalindrome(String input) {
        boolean result = true;
        input = input.toLowerCase();
        int length = input.length();
        int end = input.length();
        for (int start = 0; start < input.length(); ++start) {
            end--;
            if (start >= length || end < 0) {
                return false;
            }
            while (!Pattern.matches("[a-zA-Z]", String.valueOf(input.charAt(start)))) {
                start++;
                if (start >= length) {
                    return false;
                }
            }
            while (!Pattern.matches("[a-zA-Z]", String.valueOf(input.charAt(end)))) {
                end--;
                if (end < 0) {
                    return false;
                }
            }
            if (start >= length || end < 0) {
                return false;
            }
            if (start < end) {
                if (input.charAt(start) != input.charAt(end)) {
                    result = false;
                    break;
                }
            } else if (start == end && input.charAt(start) == input.charAt(end)) {
                if (input.charAt(start) != input.charAt(end)) {
                    result = false;
                    break;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
