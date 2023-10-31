package daa.sorting;

/**
 * Created by geetgobindsingh on 21/10/17.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ar = {2,3,1,5,4};
        System.out.println("Input Array:");
        for(Integer item : ar) {
            System.out.println(item);
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.applyBubbleSort(ar);
        System.out.println("After Applying Bubble Sorting:");
        for(Integer item : ar) {
            System.out.println(item);
        }
    }

    //verify bubbleSort logic
    public void applyBubbleSort(int[] ar) {
        int length = ar.length;
        for(int i=0; i < (length-1); ++i) {
            for(int j=(i+1); j < length; j++) {
                if(ar[i]>ar[j]) {
                    int temp = ar[j];
                    ar[j] = ar[i];
                    ar[i] = temp;
                }
            }
        }
    }
}
