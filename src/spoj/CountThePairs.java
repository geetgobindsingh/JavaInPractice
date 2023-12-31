package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CountThePairs {
    /*
    Given N integers [0<N<=10^5], count the total pairs of integers that have a difference of K. (Everything can be done with 32 bit integers).

    Input Format
    1st line contains N & K (integers).
    2nd line contains N numbers of the set. All the N numbers are distinct.
    Output Format
    One integer - the number of pairs of numbers that have a diff K.
    Sample Input :

    5 2
    1 5 3 4 2
    Sample Output :
    3

    Sample Input :
    10 1
    363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793
    Sample Output :
    0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int arraySize = Integer.parseInt(input[0]);
        int diff = Integer.parseInt(input[1]);
        String[] inputArray = br.readLine().split(" ");
        int[] ar = new int[arraySize];
        int index = 0;
        for (String item : inputArray) {
            ar[index++] = Integer.parseInt(item);
        }

        System.out.println(getCount(ar, diff));
    }

    private static int getCount(int[] ar, int diff) {
        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int item : ar) {
            if (set.contains((item - diff))) {
                count++;
            }
            if (set.contains((item + diff))) {
                count++;
            }
            set.add(item);
        }
        return count;
    }
}
