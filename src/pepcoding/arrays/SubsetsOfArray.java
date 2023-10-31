package pepcoding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SubsetsOfArray {
    // You are required to print all subsets of arr. Each subset should be
    //on separate line. For more clarity check out sample input and output.
    /*
    000
    001
    010
    011
    100
    101
    110
    111
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n];
        int index = 0;
        while (n-- > 0) {
            ar[index++] = Integer.parseInt(br.readLine());
        }
        printSubArrays(findSubArrays(ar, ar.length));
    }

    private static void printSubArrays(ArrayList<ArrayList<String>> subArrays) {
        for (ArrayList<String> list : subArrays) {
            for (String item : list) {
                System.out.print(item + " ");
            }
            System.out.print("\n");
        }
    }

    private static ArrayList<ArrayList<String>> findSubArrays(int[] ar, int length) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> list = null;

        int limit = (int) Math.pow(2, length);

        for (int i = 0; i < limit; i++) {
            list = new ArrayList<>();
            int temp = i;
            for (int j = length - 1; j >= 0; --j) {
                int r = temp % 2;
                temp = temp / 2;
                if (r == 0) {
                    list.add("-");
                } else {
                    list.add(String.valueOf(ar[j]));
                }
            }
            Collections.reverse(list);
            result.add(list);
        }

        return result;
    }
}
