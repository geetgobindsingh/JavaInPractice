package leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInRotatedSortedOrder {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter comma separated integer numbers in sorted order:");
//        String[] input = br.readLine().split(",");
//        int[] ar = new int[input.length];
        int[] ar = new int[]{5,1,3};
//        int index = 0;
//        for (String str : input) {
//            ar[index++] = Integer.parseInt(str);
//        }
        System.out.println("Enter Number to search");
        int inputNumber = Integer.parseInt(br.readLine());
        System.out.println("index is " + pivotBinarySearch(ar, inputNumber));
    }

    private static int pivotBinarySearch(int[] ar, int inputNumber) {
        int result = -1;
        int low = 0, mid = 0, high = 0;
        high = ar.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;

            if (ar[low] <= ar[high]) {
                if (ar[mid] == inputNumber) {
                    return mid;
                } else if (ar[mid] < inputNumber) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (inputNumber <= ar[high] || inputNumber <= ar[low]) {
                if (ar[mid] == inputNumber) {
                    return mid;
                } else if (ar[mid] < inputNumber) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (ar[mid] == inputNumber) {
                    return mid;
                } else if (ar[mid] < inputNumber) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }
}
