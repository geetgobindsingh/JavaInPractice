package pepcoding.pattern;

import java.util.*;
import java.io.*;

public class PrimeFactorization {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.print("Enter digit: ");
        int input = Integer.parseInt(br.readLine());
        System.out.print("\n");
        printAllPrimeFactors(input);
    }

    private static void printAllPrimeFactors(int input) {
        if (input < 0) {
            return;
        }
        int element = 2;
        while (input > 1) {
            if (input % element == 0) {
                input /= element;
                System.out.print(element + " ");
            } else {
                element++;
            }
        }
    }

}
