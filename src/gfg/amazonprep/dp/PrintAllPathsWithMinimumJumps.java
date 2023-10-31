package gfg.amazonprep.dp;

import java.util.Scanner;

public class PrintAllPathsWithMinimumJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int i = 0;
        while (i < n) {
            ar[i++] = sc.nextInt();
        }
        allPathWithMaxJump(n, ar);
        sc.close();
    }

    private static void allPathWithMaxJump(int n, int[] ar) {
        
    }
}
