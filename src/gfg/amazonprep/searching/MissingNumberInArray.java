package gfg.amazonprep.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumberInArray {
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
            int MissingNumber = MissingNumber(ar, arraySize);

            System.out.println(MissingNumber);
        }

        System.out.println("fin");
    }

    public static int MissingNumber(int array[], int n) {
        int x = 1;
        int y = 1;
        n = n - 1;
        for (int index = 0; index < n; index++) {
            x = x ^ array[index];
        }
        for (int index = 1; index <= (n+1); index++) {
            y = y ^ index;
        }
        return x ^ y;
    }
}
