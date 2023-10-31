package gfg.amazonprep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Closet0s1sAnd2s {
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
            segragate012(ar, arraySize);
            for (Integer in : ar) {
                System.out.print(in + " ");
            }
        }

        System.out.println("fin");
    }

    /*
    2
    5
    0 2 1 2 0
    3
    0 1 0
     */

    public static void segragate012(int arr[], int N) {
        int Zindex = 0;
        int Nindex = N - 1;
        while (Zindex < Nindex) {
            while (Zindex < N && arr[Zindex] == 0) {
                Zindex++;
            }
            while (Nindex > 0 && arr[Nindex] != 0) {
                Nindex--;
            }
            if (Zindex < Nindex) {
                swap(arr, Zindex, Nindex);
            }
        }

        if (Nindex == (N - 1)) {
            return;
        }

        int oneIndex = Nindex + 1;
        int twoIndex = N - 1;

        while (oneIndex < twoIndex) {
            while (oneIndex < N && arr[oneIndex] == 1) {
                oneIndex++;
            }
            while (twoIndex > Nindex && arr[twoIndex] == 2) {
                twoIndex--;
            }
            if (oneIndex < twoIndex) {
                swap(arr, oneIndex, twoIndex);
            }
        }
    }

    public static void segragate0123(int arr[], int N) {
        int _0index = 0;
        int _1index = 0;
        int _2index = N - 1;
        while (_0index < _1index) {
            while (arr[_0index] == 0 && _0index < N) {
                _0index++;
            }
            while (arr[_1index] <= 1 && _1index < N) {
                _1index++;
            }
            while (arr[_2index] == 2 && _2index > 0) {
                _2index--;
            }
            if (_0index < _1index) {
                swap(arr, _0index, _1index);
                _0index++;
                _1index++;
            }
            if (_0index < _1index) {
                swap(arr, _0index, _1index);
                _0index++;
                _1index--;
            }
        }
    }

    private static void swap(int[] ar, int index, int index1) {
        int temp = ar[index];
        ar[index] = ar[index1];
        ar[index1] = temp;
    }
}
