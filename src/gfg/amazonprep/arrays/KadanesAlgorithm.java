package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadanesAlgorithm {

    /*
    2
    5
    1 2 3 -2 5
    4
    -1 -2 -3 -4
    8
    -47 43 94 -94 -93 -59 31 -86
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
            int subarraySum = maxSubarraySum(ar, arraySize);

            System.out.println(subarraySum);
        }

        System.out.println("fin");
    }

    private static int maxSubarraySum(int arr[], int n) {
        int maxSum = 0;
        int sum = 0;
        for (int index = 0; index < n; ++index) {
            sum = arr[index] + sum;
            if (sum < 0) {
                sum = 0;
            }
            if (sum >= maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }


}
