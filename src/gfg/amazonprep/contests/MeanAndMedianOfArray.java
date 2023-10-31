package gfg.amazonprep.contests;

import java.util.Arrays;
import java.util.Scanner;

public class MeanAndMedianOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            int mean = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
                mean = mean + ar[i];
            }
            System.out.print((int) Math.floor(((float) mean / (float) n)) + " ");
            Arrays.sort(ar);
            if (n % 2 == 0) {
                System.out.println((int) Math.floor((ar[n / 2] + (ar[(n / 2) - 1])) / 2));
            } else {
                System.out.println(ar[n / 2]);
            }
        }
    }
}
