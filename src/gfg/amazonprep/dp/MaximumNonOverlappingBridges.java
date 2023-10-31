package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumNonOverlappingBridges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] north = new int[n];
        int[] south = new int[n];
        for (int i = 0; i < n; i++) {
            String[] ar = br.readLine().split(" ");
            north[i] = Integer.parseInt(ar[0]);
            south[i] = Integer.parseInt(ar[1]);
        }
        System.out.println(maximumNumberOfNonOverLappingBridges(n, north, south));
    }

    public static long maximumNumberOfNonOverLappingBridges(int n, int[] north, int[] south) {
        // 1.) first sort with North
        // 2.) Apply LIS on south


        // Insertion Sort
        int key = north[0];
        int temp = south[0];
        for (int i = 1; i < n; i++) {
            if (key > north[i] || (key == north[i] && temp > south[i])) {
                for (int j = i - 1; j >= 0; j--) {
                    if (north[j] > north[j + 1] || (north[j] == north[j + 1] && south[j] > south[j + 1])) {
                        int tempNorth = north[j + 1];
                        int tempSouth = south[j + 1];
                        north[j + 1] = north[j];
                        south[j + 1] = south[j];
                        north[j] = tempNorth;
                        south[j] = tempSouth;
                    }
                }
            }
            key = north[i];
            temp = south[i];
        }

        int[] dp = new int[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (south[j] <= south[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }
}
