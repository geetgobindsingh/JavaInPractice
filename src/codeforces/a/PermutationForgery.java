package codeforces.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PermutationForgery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int ar[] = new int[size];
            String[] sr = br.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                ar[i] = Integer.parseInt(sr[i]);
            }
            ar = getOtherPermutationWithSameFingerprint(ar);
            for (int i : ar) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    private static int[] getOtherPermutationWithSameFingerprint(int[] ar) {
        int length = ar.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (i + 1);
        }
        return permutation(arr, ar, 0, length - 1);
    }

    private static int[] permutation(int[] ar, int[] temp, int l, int r) {
        if (l == r) {
            if (isSame(getFingerPrint(ar), getFingerPrint(temp)) && !isSame(ar, temp)) {
                return ar;
            } else {
                return new int[0];
            }
        } else {
            for (int i = l; i <= r; i++) {
                swap(ar, l, i);
                int[] a = permutation(ar, temp, l + 1, r);
                if (a.length == temp.length) {
                    return a;
                }
                swap(ar, i, l);
            }
        }
        return new int[0];
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    private static boolean isSame(int[] ar1, int[] ar2) {
        if (ar1.length != ar2.length) return false;
        for (int i = 0; i < ar1.length; i++) {
            if (ar1[i] != ar2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getFingerPrint(int[] ar) {
        int[] result = new int[ar.length - 1];
        for (int i = 1; i < ar.length; i++) {
            result[i - 1] = ar[i] + ar[i - 1];
        }
        Arrays.sort(result);
        return result;
    }


}
