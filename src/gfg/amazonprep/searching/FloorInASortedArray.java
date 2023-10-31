package gfg.amazonprep.searching;

public class FloorInASortedArray {
    public static void main(String[] args) {
        long[] ar = new long[]{1, 2, 8, 10, 11, 12, 19};
//        int index = 0;
//        for (String s : sr) {
//            ar[index++] = Integer.parseInt(s);
//        }
        System.out.print(findFloor(ar, 0, ar.length - 1, 5));
    }

    public static int findFloor(long arr[], int left, int right, long x) {
        int mid = left + ((right - left) / 2);
        if (arr[mid] == x) {

        }
        return -1;
    }
}
