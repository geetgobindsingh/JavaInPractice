package gfg.amazonprep.sorting;

public class Shift0sand1sAtEnd {
    public static void main(String[] args) {
        int[] ar = new int[]{1,0,1,0,1,0};
        shift01(ar, ar.length);
        for (Integer in : ar) {
            System.out.print(in + " ");
        }
    }

    private static void shift01(int[] ar,  int n) {
        int _0index = 0;
        int _1index = n - 1;
        while (_0index < _1index) {
            while (ar[_0index] == 0 && _0index < n) {
                _0index++;
            }
            while (ar[_1index] == 1 && _1index > 0) {
                _1index--;
            }
            if (_0index < _1index) {
                swap(ar, _0index, _1index);
                _0index++;
                _1index--;
            }
        }


//        for (int index = 0; index < n; ++index) {
//
//        }
    }

    private static void swap(int[] ar, int index, int index1) {
        int temp = ar[index];
        ar[index] = ar[index1];
        ar[index1] = temp;
    }
}
