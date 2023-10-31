package gfg.amazonprep.arrays;

public class MaximumIndex {
    public static void main(String[] args) {
        System.out.println(maxIndexDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}, 9));
    }

    public static int maxIndexDiff(int arr[], int n) {
        int i = 0;
        int j = n - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            if (arr[i] <= arr[j]) {
                if (max < (j - i)) {
                    max = j - i;
                }
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
