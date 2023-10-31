package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumDistanceBetweenTwoNumbers {

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
            sr = br.readLine().split(" ");
            int aa = minDist2(ar, arraySize, Integer.parseInt(sr[0]), Integer.parseInt(sr[1]));
            System.out.println(aa);
        }

        System.out.println("fin");
    }
    /*
    * 3
      4
      1 2 3 2
      1 2
      7
      86 39 90 67 84 66 62
      42 12
      83
      98 78 10 12 59 37 45 18 1 56 37 14 3 32 85 10 69 89 29 93 44 16 26 13 50 75 79 21 20 33 55 17 63 64 80 21 52 24 90 52 80 26 18 34 57 2 95 25 42 23 17 85 39 94 50 40 21 28 12 40 61 67 9 23 30 88 95 34 64 85 85 95 62 54 28 19 55 22 95 49 97 64 33
      34 56
      62
      96 82 48 76 34 19 7 80 36 57 77 34 19 35 5 57 16 66 42 62 89 19 60 19 25 16 20 51 77 75 12 73 8 11 100 93 81 58 72 17 14 48 2 33 82 6 41 49 72 34 10 12 53 21 30 77 36 49 79 13 75 42
      36 33
      34
      12 16 72 18 44 78 55 99 50 46 12 40 84 4 27 75 38 75 52 40 12 8 90 50 59 99 12 9 66 41 94 30 8 65
      46 50
      Sample Output:
      1
      -1
    * */

    public static int minDist(int a[], int n, int x, int y) {
        int minDis = -1;
        int dist = -1;
        int start = -1;
        int end = -1;
        for (int index = 0; index < n; index++) {
            if (a[index] == x && (start == -1 || start == x)) {
                start = x;
                end = y;
                dist = 0;
                continue;
            }
            if (a[index] == y && (start == -1 || start == y)) {
                start = y;
                end = x;
                dist = 0;
                continue;
            }
            if (dist > -1 && start > -1 && end > -1) {
                dist++;
            }
            if (a[index] == end && end > -1 && dist > -1) {
                if (minDis == -1) {
                    minDis = dist;
                } else if (minDis > dist) {
                    minDis = dist;
                }
                int temp = start;
                start = end;
                end = temp;
                dist = 0;
            }
        }
        return minDis;
    }


    public static int minDist2(int arr[], int n, int x, int y) {
        int minDis = Integer.MAX_VALUE;
        int i = 0;
        int p = -1;
        for (i = 0; i < n; i++) {
            if (arr[i] == x || arr[i] == y) {
                //we will check if p is not equal to -1 and
                //If the element at current index matches with
                //the element at index p , If yes then update
                //the minimum distance if needed
                if (p != -1 && arr[i] != arr[p]) {
                    minDis = Math.min(minDis, i - p);
                }
                //update the previous index
                p = i;
            }
        }
        //If distance is equal to int max
        if (minDis == Integer.MAX_VALUE) {
            return -1;
        }
        return minDis;
    }

}
