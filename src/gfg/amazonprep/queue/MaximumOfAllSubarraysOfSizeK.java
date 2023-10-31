package gfg.amazonprep.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        String[] sr = "8 5 10 7 9 4 15 12 90 13".split(" ");
        int ar[] = new int[sr.length];
        int index = 0;
        for (String s : sr) {
            ar[index++] = Integer.parseInt(s);
        }
        for (Integer i : max_of_subarrays(ar, ar.length, 4)) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (Integer i : max_of_subarrays1(ar, ar.length, 4)) {
            System.out.print(i + " ");
        }
    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (max < arr[i]) {
                secondMax = max;
                max = arr[i];
            }
        }
        result.add(max);
        if (arr[0] == max) {
            max = secondMax;
        }
        for (int i = k; i < n; i++) {
            if (max < arr[i]) {
                secondMax = max;
                max = arr[i];
            }
            result.add(max);
            if (arr[i - k + 1] == max) {
                max = secondMax;
            }
        }
        return result;
    }

    static ArrayList<Integer> max_of_subarrays1(int arr[], int n, int k) { // O(nLogk)
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        result.add(queue.peek());

        queue.remove(arr[0]);

        for (int i = k; i < n; i++) {

            queue.add(arr[i]);

            result.add(queue.peek());

            queue.remove(arr[i - k + 1]);
        }
        return result;
    }
}
