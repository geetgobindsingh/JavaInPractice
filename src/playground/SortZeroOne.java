package playground;

public class SortZeroOne {
    public static void main(String[] args) {
        int ar[] = new int[]{0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0};
        int i = 0;
        int j = ar.length - 1;
        while (i < j) {
            while (i < ar.length - 1 && ar[i] == 0) {
                i++;
            }
            while (j > 0 && ar[j] == 1) {
                j--;
            }
            if (i < j) {
                swap(ar, i, j);
            }
        }


        for (int a : ar) {
            System.out.print(a + " ");
        }
    }

    private static void swap(int ar[], int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
