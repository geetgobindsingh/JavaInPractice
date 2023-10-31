package gfg.amazonprep.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInASortedAndRotatedArray {
    /*
    Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K.
     The task is to find the index of the given element K in the array A.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases--;
            int arraySize;
            arraySize = Integer.parseInt(br.readLine());
            int ar[] = new int[arraySize];
            String[] sr = br.readLine().split(" ");
            int index = 0;
            for (String str : sr) {
                ar[index++] = Integer.parseInt(str);
            }
            int Search = Search(ar, Integer.parseInt(br.readLine()));

            System.out.println(Search);
        }

        System.out.println("fin");
    }

    /*
    3
    9
    5 6 7 8 9 10 1 2 3
    10
    3
    3 1 2
    1
    4
    3 5 1 2
    6
     */

    public static int Search(int array[], int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + ((right - left) / 2));
            if (array[mid] == target) {
                return mid;
            }
            if (array[left] <= array[mid] && array[mid] <= array[right]) {
                if (target > array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
