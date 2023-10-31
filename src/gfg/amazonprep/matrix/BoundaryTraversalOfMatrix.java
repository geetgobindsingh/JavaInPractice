package gfg.amazonprep.matrix;

import java.util.ArrayList;

public class BoundaryTraversalOfMatrix {
    public static void main(String[] args) {
        for (Integer i : boundaryTraversal(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}}, 4, 4)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> boundaryTraversal(int A[][], int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        if (left > right) {
           return result;
        }
        for (int i = left; i <= right; i++) {
            result.add(A[top][i]);
        }
        top++;
        if (top > bottom) {
            return result;
        }

        for (int i = top; i <= bottom; i++) {
            result.add(A[i][right]);
        }
        right--;
        if (left > right) {
            return result;
        }
        for (int i = right; i >= left; i--) {
            result.add(A[bottom][i]);
        }
        bottom--;
        if (top > bottom) {
            return result;
        }

        for (int i = bottom; i >= top; i--) {
            result.add(A[i][left]);
        }
        left++;

        return result;
    }
}
