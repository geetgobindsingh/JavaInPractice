package gfg.amazonprep.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThirdLargestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tesCases = Integer.parseInt(br.readLine());
        if (tesCases <= 0 || tesCases > 100) {
            return;
        }

        while (tesCases > 0) {
            tesCases = tesCases - 1;
            int arraySize = Integer.parseInt(br.readLine());
            int ar[] = new int[arraySize];
            String[] sr = br.readLine().split(" ");
            int index = 0;
            for (String str : sr) {
                ar[index++] = Integer.parseInt(str);
            }
            System.out.println(thirdLargest(ar, arraySize));
        }

        System.out.println("fin");
    }

    public static int thirdLargest(int a[], int n) {
        int result = -1;
        int firstLargestIndex = 0;
        int secondLargestIndex = 0;
        int thirdLargestIndex = 0;
        for (int index = 0; index < n; ++index) {
            if (a[index] > a[firstLargestIndex]) {
                firstLargestIndex = index;
            }
        }
        for (int index = 0; index < n; ++index) {
            if (a[index] > a[secondLargestIndex] && index != firstLargestIndex) {
                secondLargestIndex = index;
            }
        }
        for (int index = 0; index < n; ++index) {
            if (a[index] >= a[thirdLargestIndex] && index != firstLargestIndex
                    && index != secondLargestIndex) {
                thirdLargestIndex = index;
                result = a[index];
            }
        }
        return result;
    }
}
