package gfg.amazonprep.searching;

import java.util.Arrays;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
//        String[] sr = "1 2 3 4 5".split(" ");
        String[] sr = "0 -10 1 3 -20".split(" ");
//        String[] sr = "5 4 3 2 1".split(" ");
//        String[] sr = "47 1 4 49 -18 10 26 18 -11 -38 -24 36 44 -11 45 20 -16 28 17 -49 47 -48 -33 42 2 6 -49 30 36 -9 15 39 -6 -31 -10 -21 -19 -33 47 21 31 25 -41 -23 17 6 47 3 36 15 -44 33 -31 -26 -22 21 -18 -21 -47 -31 20 18 -42 -35 -10 -1 46 -27 -32 -5 -4 1 -29 5 29 38 14 -22 -9 0 43 -50 -16 14 -26"
//                .split(" ");
        int[] ar = new int[sr.length];
        int index = 0;
        for (String s : sr) {
            ar[index++] = Integer.parseInt(s);
        }
        System.out.print(MissingNumber(ar, ar.length));
    }

    public static int findMissing(int arr[], int size) {
        int min = Integer.MAX_VALUE;
        int maxMin = Integer.MAX_VALUE;
        int missing = 0;

        for (int index = 0; index < size; index++) {
            if (arr[index] > -1) {
                if (arr[index] < min) {
                    min = arr[index];
                    missing = min + 1;
                } else if (arr[index] == missing) {
                    min = arr[index];
                    missing = min + 1;
                }
            }
        }
        return missing;
    }

    public static int MissingNumber(int array[], int n) {
        int x = 1;
        int y = 1;
        for (int index = 0; index < n; index++) {
            if (array[index] >= 0) {
                x = x ^ array[index];
            }
        }
        for (int index = 1; index <= (n+1); index++) {
            y = y ^ index;
        }
        return x ^ y;
    }
}
