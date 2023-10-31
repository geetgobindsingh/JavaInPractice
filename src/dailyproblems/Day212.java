package dailyproblems;

import java.util.Scanner;

public class Day212 {

    /*
    Spreadsheets often use this alphabetical encoding for its columns:
    "A", "B", "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....

    Given a column number, return its alphabetical column id.
    For example, given 1, return "A". Given 27, return "AA".
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Column Index: ");

        int column = scanner.nextInt();

        System.out.println("Result: " + getColumnName(column));

    }

    private static String getColumnName(int column) {
        if (column < 0) {
            return "No Negative column allowed!";
        }  else if (column == 0) {
            return "Zero column does not exist!";
        } else if (column <= 26) {
            return getStringFormOfColumn(column);
        } else {
            return (((column % 26) == 0) ? getColumnName((column / 26) - 1) : getColumnName(column / 26)) + getStringFormOfColumn(column % 26);
        }
    }

     private static String getStringFormOfColumn(int column) {
        if (column == 0) {
            return String.valueOf((char) (26 + 'A' - 1));
        }
        return String.valueOf((char) (column + 'A' - 1));
     }
}

//1 => 00A => 0 * (26^2) + 0 * (26^1) + 1 * (26^0)
//26 => 00Z
//27 => 0A0 -> A => 0 * (26^2) + 0 * (26^1) + 1 * (26^0)
//
//A - 1
//AA - 27 => 26 + 1
//AAA - 703 => 26^26 + 26 + 1
//677 -> ZZ
//678 -> AAA
