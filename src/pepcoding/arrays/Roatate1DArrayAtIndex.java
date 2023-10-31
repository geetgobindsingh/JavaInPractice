package pepcoding.arrays;

public class Roatate1DArrayAtIndex {
    public static void main(String[] args) {
        int ar[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int rotateIndex = 5;
        rotateArray(ar, rotateIndex);
        printArray(ar);
    }

    private static void printArray(int[] ar) {
        for (int a : ar) {
            System.out.print(a + ", ");
        }
    }

    // Note: do not use this algo
    // Note: reverse always iterate till middle only because more then middle will make it same array
    private static void reverse(int[] ar, int start, int end) {
        int l = end - start + 1;
        for (int i = 0; i < l / 2; i++) {
            int currentIndex = i + start;
            int mirrorIndex = ((l - 1) - i) + start;
            // swap
            ar[currentIndex] = (ar[currentIndex] + ar[mirrorIndex]) - (ar[mirrorIndex] = ar[currentIndex]);
        }
    }

    // use this to reverse the array
    private static void simpleReverse(int[] ar, int start, int end) {
        while (start < end) {
            ar[start] = (ar[start] + ar[end]) - (ar[end] = ar[start]);
            start++;
            end--;
        }
    }

    private static void rotateArray(int[] ar, int rotateIndex) {
        int n = ar.length;
        if (rotateIndex < 0 || rotateIndex >= n) {
            return;
        }
        simpleReverse(ar, 0, rotateIndex - 1);
        simpleReverse(ar, rotateIndex, n - 1);
        simpleReverse(ar, 0, n - 1);
    }
}
