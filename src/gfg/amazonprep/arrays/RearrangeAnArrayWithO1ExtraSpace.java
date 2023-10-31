package gfg.amazonprep.arrays;

public class RearrangeAnArrayWithO1ExtraSpace {
    public static void main(String[] args) {
//        int[] ar = new int[]{4, 0, 2, 1, 3};
        int[] ar = new int[]{5, 0, 3, 7, 1, 4, 6, 2};
        arrange(ar, ar.length);
        for (long a : ar) {
            System.out.print(a);
        }
    }

    public static void arrange(int arr[], int n) {

        int key = 0;
        int oldVal = arr[key];
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            if (key == arr[i]) {
                arr[i] = oldVal;
            } else {
                arr[i] = arr[arr[i]];
            }
            if (arr[i] != arr[arr[i]]) {
                key = i;
                oldVal = temp;
            }
        }
    }
}
