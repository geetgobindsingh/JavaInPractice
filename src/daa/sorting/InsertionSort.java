package daa.sorting;

/**
 * Created by geetgobindsingh on 21/10/17.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] ar = {2,3,1,5,4};
        System.out.println("Input Array:");
        for(Integer item : ar) {
            System.out.print(item + " ");
        }
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.applyInsertionSort(ar);
        System.out.println();
        System.out.println("After Applying Selection Sorting:");
        for(Integer item : ar) {
            System.out.print(item + " ");
        }
    }

    public void applyInsertionSort(int[] ar) {
        int length = ar.length;
        int x = ar[0];
        for (int k = 1; k < length; ++k) {
            if (x > ar[k]) {
                for (int j = (k - 1); j >= 0; --j) {
                    if (ar[j] > ar[j + 1]) {
                        swap(ar, j + 1, j);
                    }
                }
            }
            x = ar[k];
        }
    }

    private void swap(int[] ar, int indexA, int indexB) {
        int temp = ar[indexA];
        ar[indexA] = ar[indexB];
        ar[indexB] = temp;
    }
}
