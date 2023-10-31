package gfg.amazonprep.heap;

import java.util.*;

public class FindMedianInAStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FindMedian findMedian = new FindMedian();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            findMedian.insertHeap(x);
            System.out.println((int) Math.floor(findMedian.getMedian()));
        }
    }

    static class FindMedian { // O(n^2)
        static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        static PriorityQueue<Integer> min = new PriorityQueue<>();
        static PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Function to insert heap
        public static void insertHeap(int x) {
            heap.add(x);
        }

        // Function to balance Heaps
        public static void balanceHeaps() {
            int half = heap.size() / 2;
            max.clear();
            min.clear();
            List<Integer> list = new ArrayList<>();
            int temp;
            if (heap.size() == 1) {
                temp = heap.poll();
                max.add(temp);
                list.add(temp);
            } else {
                while (!heap.isEmpty()) {
                    if (half < heap.size()) {
                        temp = heap.poll();
                        max.add(temp);
                        list.add(temp);
                    } else {
                        temp = heap.poll();
                        min.add(temp);
                        list.add(temp);
                    }
                }
            }
            for (int index = 0; index < list.size(); ++index) {
                heap.add(list.get(index));
            }
        }

        // function to getMedian
        public static double getMedian() {
            balanceHeaps();
            // add your code here
            if (max.size() == min.size()) {
                return (max.peek() + min.peek()) / 2;
            }
            return max.peek();
        }

    }
}
