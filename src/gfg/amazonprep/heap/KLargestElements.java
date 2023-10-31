package gfg.amazonprep.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    public static void main(String[] args) {
        int[] ar = new int[]{12,5,787,1,23};
        System.out.print(kLargest(ar, ar.length, 2));
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            max.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (k > 0) {
            k--;
            result.add(max.poll());
        }
        return result;
    }
}
