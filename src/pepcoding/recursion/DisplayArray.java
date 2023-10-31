package pepcoding.recursion;

public class DisplayArray {
    public static void main(String[] args) {
        int ar[] = new int[]{1, 2, 3, 4, 5};
        displayArr(ar, 0);
        displayArrInReverse(ar, 0);
        System.out.print(maxInArray(ar, 0));
    }

    private static void displayArr(int[] arr, int idx) {
        if (idx < arr.length) {
            System.out.println(arr[idx]);
            displayArr(arr, idx + 1);
        }
    }

    private static void displayArrInReverse(int[] arr, int idx) {
        if (idx < arr.length) {
            displayArr(arr, idx + 1);
            System.out.println(arr[idx]);
        }
    }

    private static int maxInArray(int[] ar, int i) {
        if (i < ar.length) {
            int max = ar[i];
            return Math.max(max, maxInArray(ar, i + 1));
        }
        return 0;
    }
}
