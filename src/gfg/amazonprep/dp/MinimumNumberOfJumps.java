package gfg.amazonprep.dp;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        String[] sr = "2 1 0 3".split(" ");
        int[] ar = new int[sr.length];
        for (int i = 0; i < sr.length; i++) {
            ar[i] = Integer.parseInt(sr[i]);
        }
        for (int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.print(minimumJumps(ar, ar.length));
    }

    public static int minimumJumps(int arr[], int n) {
        if (arr[0] == 0) return -1;
        int matrix[] = new int[n];
        int result = count(arr, n, matrix);
        for (int i : matrix) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        return result;
    }

    public static int count(int arr[], int n, int[] matrix) {
        for (int i = (n - 2); i >= 0; i--) {
            if (arr[i] == 0) {
                matrix[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = arr[i]; j >= 1; j--) {
                    if ((i+j) == (n-1)) {
                        min = 0;
                        break;
                    } else if ((i + j) < (n - 1) && matrix[i + j] != 0) {
                        min = Math.min(min, matrix[i + j]);
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    matrix[i] = 0;
                } else {
                    matrix[i] = 1 + min;
                }
            }
        }
        return matrix[0] == 0 ? -1 : matrix[0];
    }
}
