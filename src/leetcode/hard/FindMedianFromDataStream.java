package leetcode.hard;

import javax.swing.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

   static class MedianFinder {

       final PriorityQueue<Integer> left;
       final PriorityQueue<Integer> right;
        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (right.size() > 0 && num > right.peek()) {
                right.offer(num);
            } else {
                left.offer(num);
            }
            if (left.size() - right.size() == 2) {
                right.offer(left.poll());
            } else if (right.size() - left.size() == 2) {
                left.offer(right.poll());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (float) (left.peek() + right.peek()) / 2;
            } else if (left.size() < right.size()) {
                return right.peek();
            } else {
                return left.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }


}
