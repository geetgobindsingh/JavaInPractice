package gfg.amazonprep.matrix;

public class FindNthElementOfSpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        int matrix[][] = new int[][]{
//                {5 ,11, 30},
//                {5, 19, 19}
//        };
        System.out.print(findK(matrix, matrix.length, matrix[0].length, 9));
    }

    public static int findK(int A[][], int n, int m, int k) {
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                if (count == k) {
                    return A[top][i];
                } else {
                    count++;
                }
            }
            top++;

            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                if (count == k) {
                    return A[i][right];
                } else {
                    count++;
                }
            }
            right--;

            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                if (count == k) {
                    return A[bottom][i];
                } else {
                    count++;
                }
            }
            bottom--;

            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                if (count == k) {
                    return A[i][left];
                } else {
                    count++;
                }
            }
            left++;
        }
        return -1;
    }
}
