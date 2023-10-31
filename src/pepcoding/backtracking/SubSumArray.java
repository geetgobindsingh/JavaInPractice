package pepcoding.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubSumArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int index = 0;
        int[] ar = new int[n];
        while (index < n) {
            ar[index] = Integer.parseInt(br.readLine());
            index++;
        }
        int tar = Integer.parseInt(br.readLine());
        printTargetSumSubsets(ar, 0, "", 0, tar);
    }

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if (idx == arr.length) {
            if (sos == tar) {
                System.out.println(set + ".");
                return;
            }
            if (sos > tar) {
                return;
            }
            return;
        }


        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ",", sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
}
