package gfg.amazonprep.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
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
            int majorityElement = majorityElement(ar, arraySize);

            System.out.println(majorityElement);
        }

        System.out.println("fin");
    }
    /*
    Given an array A of N elements. Find the majority element in the array.
    A majority element in an array A of size N is an element that appears more than N/2 times in the array.
    2
    5
    3 1 3 3 2
    3
    1 2 3
     */

    public static int majorityElement(int a[], int size) {
        int maj = -1;
        if (size == 0) {
            return maj;
        }
        if (size == 1) {
            return a[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < size; ++index) {
            if (map.containsKey(a[index])) {
                map.put(a[index], map.get(a[index]) + 1);
            } else {
                map.put(a[index], 1);
            }
        }
        for (int in : map.keySet()) {
            int count = map.get(in);
            if (count > (size / 2)) {
                maj = in;
            }
        }
        return maj;
    }
}
