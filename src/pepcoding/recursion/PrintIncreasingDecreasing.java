package pepcoding.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintIncreasingDecreasing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printIncreasing(n);
        System.out.print("\n");
        printDecreasing(n);
        System.out.print("\n");
        printDecreasingIncreasing(n);
    }

    private static void printIncreasing(int n) {
        if (n == 0) return;
        printIncreasing(n - 1);
        System.out.print(n + " ");
    }

    private static void printDecreasing(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printDecreasing(n - 1);
    }

    private static void printDecreasingIncreasing(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printDecreasingIncreasing(n - 1);
        System.out.print(n + " ");
    }
}
