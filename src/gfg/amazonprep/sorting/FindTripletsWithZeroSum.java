package gfg.amazonprep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTripletsWithZeroSum {
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
            System.out.println(findTriplets(ar, arraySize));
        }

        System.out.println("fin");
    }

    /*
    2
    5
    0 -1 2 -3 1
    3
    1 2 3
    7
    4 -16 43 4 7 -36 18
     */

    public static boolean findTriplets(int arr[], int n) {
        //add code here.
        Set<Integer> set = new HashSet<>();
        for (Integer in : arr) {
            set.add(in);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = (arr[i] + arr[j]);
                if (sum != arr[i] && sum != arr[j] && -sum != arr[i] && -sum != arr[j] && set.contains(-sum)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean findTriplets2(int arr[], int n) {
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l] + " ");
                    System.out.println(arr[r] + " ");

                    l++;
                    r--;
                    found = true;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero than
                    // decrement in right side
                else
                    r--;
            }
        }

        return found;
    }
}
