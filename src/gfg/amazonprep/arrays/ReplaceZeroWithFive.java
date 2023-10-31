package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReplaceZeroWithFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases = tesCases - 1;
            int n = Integer.parseInt(br.readLine());
            if (n <= 0 || n > 10000) {
               // no-op
            } else {
                System.out.println(convertFive(n));
            }
        }

        System.out.println("fin");
    }

    private static int convertFive(int n) {
        String result = "";
        String integer = String.valueOf(n);
        for (int index = 0; index < integer.length(); ++index) {
            result = result + ((integer.charAt(index) == '0') ? "5" : integer.charAt(index));
        }
        return Integer.parseInt(result);
    }
}
