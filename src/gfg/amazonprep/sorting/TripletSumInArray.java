package gfg.amazonprep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases--;
            int arraySize;
            String[] sr = br.readLine().split(" ");
            int n = Integer.parseInt(sr[0]);
            int x = Integer.parseInt(sr[1]);
            sr = br.readLine().split(" ");
            arraySize = n;
            int ar[] = new int[arraySize];
            int index = 0;
            for (String str : sr) {
                ar[index++] = Integer.parseInt(str);
            }
            int aa = find3Numbers(ar, n, x);
            System.out.println(aa);
        }

        System.out.println("fin");
    }

    /*
    2
    6 13
    1 4 45 6 10 8
    5 10
    1 2 4 3 6
     */

    public static int find3Numbers(int arr[], int N, int X) {
        Arrays.sort(arr);
        for (int i = 0; i < N; ++i) {
            int l = i + 1;
            int r = N - 1;
            while (l < r) {
                if ((arr[i] + arr[l] + arr[r]) == X) {
                    return 1;
                } else if ((arr[i] + arr[l] + arr[r]) < X) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return 0;
    }
}
