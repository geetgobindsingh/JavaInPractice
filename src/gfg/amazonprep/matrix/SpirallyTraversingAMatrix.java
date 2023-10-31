package gfg.amazonprep.matrix;

import java.util.ArrayList;

public class SpirallyTraversingAMatrix {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

//        int matrix[][] = new int[][]{
//                {5 ,11, 30},
//                {5, 19, 19}
//        };
        for (Integer i : spirallyTraverse(matrix, matrix.length, matrix[0].length)) {
            System.out.print(i + " ");
        }
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = c - 1;
        int top = 0;
        int bottom = r - 1;

        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
