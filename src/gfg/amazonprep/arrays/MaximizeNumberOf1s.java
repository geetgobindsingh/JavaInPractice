package gfg.amazonprep.arrays;

import java.util.Scanner;

public class MaximizeNumberOf1s {
    /*
    Given a binary array arr of size N and an integer M.
    Find the maximum number of consecutive 1's produced by flipping at most M 0's.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int i = 0;
        while (n-- > 0) {
            ar[i++] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(findZeroes(ar, n, m));
    }

    /*
    N = 11
    arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
    M = 2
    Output: 8
     */

    public static int findZeroes(int arr[], int n, int m) {
        for (int i = 0; i < n; i++) {
            int left = i;

//            while() {
//
//            }
        }
        return 1;
    }
}
