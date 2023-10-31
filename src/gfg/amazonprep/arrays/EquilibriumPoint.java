package gfg.amazonprep.arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {
        String[] ar = "20 17 42 25 32 32 30 32 37 9 2 33 31 17 14 40 9 12 36 21 8 33 6 6 10 37 12 26 21 3".split(" ");
        long[] arr = new long[ar.length];
        int i = 0;
        for (String s : ar) {
            arr[i++] = Long.parseLong(s);
        }
        System.out.print(equilibriumPoint(arr, arr.length));


    }

    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int i = 0;
        long sum = arr[i];
        for (int index = 1; index < n; index++) {
            if (sum < arr[index]) {
                int j = 1;
                long rightSum = 0;
                while (j <= (i + 1) && (index + j) < n) {
                    rightSum = rightSum + arr[index + j];
                    j++;
                }
                if (sum == rightSum) {
                    return index + 1;
                }
            }
            sum = sum + arr[index];
            i++;
        }
        return -1;
    }
}
