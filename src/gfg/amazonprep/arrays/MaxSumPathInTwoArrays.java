package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumPathInTwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases--;
            String[] sr = br.readLine().split(" ");
            int arraySize1 = Integer.parseInt(sr[0]);
            int arraySize2 = Integer.parseInt(sr[1]);
            int ar1[] = new int[arraySize1];
            String[] arr = br.readLine().split(" ");
            int index = 0;
            for (String str : arr) {
                ar1[index++] = Integer.parseInt(str);
            }
            int ar2[] = new int[arraySize2];
            arr = br.readLine().split(" ");
            index = 0;
            for (String str : arr) {
                ar2[index++] = Integer.parseInt(str);
            }
            System.out.println(maxPathSum(ar1, ar2));
        }

        System.out.println("fin");
    }

    /*
    2
    5 4
    2 3 7 10 12
    1 5 7 8
    3 3
    1 2 4
    1 2 7
    5 5
    1 1 1 2 2
    1 1 1 1 1 2 2
     */

    public static int maxPathSum(int ar1[], int ar2[]) {
        return maxPathSum(ar1, ar2, 0, Math.max(ar1.length, ar2.length));
    }

    public static int maxPathSum(int ar1[], int ar2[], int start, int end) {
        int i = start;
        int a = 0;
        int b = 0;
        boolean common = false;
        while (i < end) {
            if (i < ar1.length && i < ar2.length && ar1[i] == ar2[i]) {
                common = true;
                break;
            } else if (i < ar1.length && i < ar2.length) {
                a = a + ar1[i];
                b = b + ar2[i];
                i++;
            } else {
                break;
            }
        }
        if (common) {
            int commonSum = 0;
            int k = i;
            while (k < ar1.length && k < ar2.length && ar1[k] == ar2[k]) {
                commonSum = commonSum + ar1[k++];
            }
            return maxPathSum(ar1, ar2, start, i) + commonSum + maxPathSum(ar1, ar2, k, end);
        } else {
            int j = i;
            while (i < end && i < ar1.length) {
                a = a + ar1[i++];
            }
            while (j < end && j < ar2.length) {
                b = b + ar2[j++];
            }
            return Math.max(a, b);
        }
    }
}
