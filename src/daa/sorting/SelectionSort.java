package daa.sorting;

/**
 * Created by geetgobindsingh on 21/10/17.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] ar = {2,3,1,5,4};
        System.out.println("Input Array:");
        for(Integer item : ar) {
            System.out.println(item);
        }
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.applySelectionSort(ar);
        System.out.println("After Applying Selection Sorting:");
        for(Integer item : ar) {
            System.out.println(item);
        }
    }


    public void applySelectionSort(int[] ar) {
        int length = ar.length;
        int smallestItemIndex = 0;
        for(int i = 0; i < length; ++i) {
            smallestItemIndex = i;
            for(int j=(i+1); j< length; ++j) {
                if(ar[smallestItemIndex] > ar[j]) {
                    smallestItemIndex = j;
                }
            }
            int temp = ar[i];
            ar[i] = ar[smallestItemIndex];
            ar[smallestItemIndex] = temp;
        }
    }
}
