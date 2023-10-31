package pepcoding.recursion;

public class PrintIncreasingDecreasingArray {
    public static void main(String[] args) {
        int ar[] = new int[]{1, 2, 3, 4, 5, 6};
        printIncreasing(ar, 0, ar.length);
        System.out.print("\n");
        printDecreasing(ar, 0, ar.length);
    }

    // fun call ke pahle ka code to the base
    private static void printIncreasing(int[] ar, int i, int n) {
        if (i == n) {
            return;
        }
        System.out.print(ar[i] + " ");
        printIncreasing(ar, i + 1, n);
    }

    // fun call ke baad ka code from the base
    private static void printDecreasing(int[] ar, int i, int n) {
        if (i == n) {
            return;
        }
        printDecreasing(ar, i + 1, n);
        System.out.print(ar[i] + " ");
    }
}
