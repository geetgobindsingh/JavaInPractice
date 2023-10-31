package gfg.amazonprep.searching;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCasesCount = sc.nextInt();
        while (testCasesCount > 0) {
            testCasesCount--;
            System.out.println(floorSqrt(sc.nextInt()));
        }
    }

    public static long floorSqrt(long x) {
        return (long) Math.sqrt(x);
    }
}
