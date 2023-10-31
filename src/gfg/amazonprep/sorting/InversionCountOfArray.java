package gfg.amazonprep.sorting;

public class InversionCountOfArray {
    public static void main(String[] args) {
        long[] ar = new long[]{2, 4, 3, 1, 5};
        System.out.println(inversionCount(ar, ar.length));
    }

    public static long inversionCount(long arr[], long N) {
        int inversionCount = 0;
//        for (int index = 1; index < N - 1; index++) {
//            long x = arr[index];
//            int k = index - 1;
//            while (x > arr[k]) {
//                swap(arr, );
//            }
//        }
        return inversionCount;
    }

    private static void swap(int[] ar, int index, int index1) {
        int temp = ar[index];
        ar[index] = ar[index1];
        ar[index1] = temp;
    }
}
