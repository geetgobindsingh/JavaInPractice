package gfg.amazonprep.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {
    public static void main(String[] args) {

    }

//    ArrayList<Integer> nearlySorted(int arr[], int num, int k) { // O(NlongK)
//    }

    ArrayList<Integer> nearlySorted1(int arr[], int num, int k) { // O(NlongN)
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int j : arr) {
            heap.add(j);
        }

        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }
}
