package pepcoding.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetStairsPath {
    // n=3, then all the paths are 111, 12, 21, 3.
    // [given only three type of steps are allowed: 1,2,3]
    public static void main(String[] args) throws IOException {
        int input = Integer.parseInt(
                new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print(getStairsPath(input));
        System.out.print("\n");
        printStairPaths(input, "");
    }

    private static void printStairPaths(int input, String paths) {
        if (input == 0) {
            System.out.println(paths);
            return;
        } else if (input < 0) {
            return;
        }
        printStairPaths(input - 1, paths + 1);
        printStairPaths(input - 2, paths + 2);
        printStairPaths(input - 3, paths + 3);
    }

    private static ArrayList<String> getStairsPath(int n) { // T = O(3 ^ N)
        if (n == 0) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        } else if (n < 0) {
            ArrayList<String> result = new ArrayList<>();
            return result;
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> pathStep1 = getStairsPath(n - 1);
        for (String steps : pathStep1) {
            result.add("1" + steps);
        }
        ArrayList<String> pathStep2 = getStairsPath(n - 2);
        for (String steps : pathStep2) {
            result.add("2" + steps);
        }
        ArrayList<String> pathStep3 = getStairsPath(n - 3);
        for (String steps : pathStep3) {
            result.add("3" + steps);
        }
        return result;
    }
}
