package dailyproblems;

import java.util.Scanner;

public class Day211 {

    /*
    Given a string and a pattern,
    find the starting indices of all occurrences of the pattern in the string.
    For example, given the string "abracadabra" and the pattern "abr",
    you should return [0, 7].
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Input: ");

        String input = scanner.nextLine();

        if (input.length() == 0) {
            System.out.println("Entered Input cannot be empty!");
            return;
        }

        System.out.println("Enter Pattern: ");

        String pattern = scanner.nextLine();

        if (pattern.length() == 0) {
            System.out.println("Entered pattern cannot be empty!");
            return;
        }

        System.out.println("Result is: " + getResult(input, pattern));
    }

    private static String getResult(String input, String pattern) {
        String result = "[";
        if (input.contains(pattern)) {
            for (int index = 0; (index + pattern.length()) < (input.length()); ++index) {
                if (input.substring(index, pattern.length()).equalsIgnoreCase(pattern)) {
                    if (index == 0) {result = result + input;}
                    else { result = result + ", " + index; }
                }
            }
        } else {
            return "Entered Pattern not found, in given input!";
        }
        return result + "]";
    }
}
