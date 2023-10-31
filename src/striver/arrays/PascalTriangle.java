package striver.arrays;

import java.util.ArrayList;

public class PascalTriangle {
    //https://www.codingninjas.com/codestudio/problems/pascal-s-triangle_1089580?topList=striver-sde-sheet-problems
    public static void main(String[] args) {
        /*
        input: 4
        output:
        1
        1 1
        1 2 1
        1 3 3 1
         */
        display(bruteForcePrintPascal(7));
        display(optimisedApproachPrintPascal(7));
    }

    private static void display(ArrayList<ArrayList<Long>> superList) {
        for (ArrayList<Long> list : superList) {
            for (Long item : list) {
                System.out.print(item + " ");
            }
            System.out.print("\n");
        }
    }

    private static ArrayList<ArrayList<Long>> bruteForcePrintPascal(int n) { // O(N^2)
        ArrayList<ArrayList<Long>> result = new ArrayList<>();
        ArrayList<Long> list = null;
        if (n <= 0) {
            return result;
        }

        Long[][] matrix = new Long[n+1][n];

        for (int row = 0; row < n + 1; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = 0L;
            }
        }

        matrix[1][0] = 1L;

        for (int col = 1; col < n; col++) {
            for (int row = 1; row <= (col + 1); row++) {
                matrix[row][col] = matrix[row][col - 1] + matrix[row - 1][col - 1];
            }
        }

        for (int gap = 0; gap < n; gap++) {
            list = new ArrayList<>();
            for (int i = 0, j = gap; i <= gap; i++) {
                list.add(matrix[i+ 1][j]);
            }
            result.add(list);
        }
        return result;
    }

    private static ArrayList<ArrayList<Long>> optimisedApproachPrintPascal(int n) { // O(N)
        ArrayList<ArrayList<Long>> result = new ArrayList<>();
        ArrayList<Long> current, pre = null;
        if (n <= 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 | j == i) {
                    current.add(1L);
                } else {
                    current.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = current;
            result.add(current);
        }
        return result;
    }
}
