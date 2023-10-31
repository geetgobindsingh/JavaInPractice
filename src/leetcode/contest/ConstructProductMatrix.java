package leetcode.contest;

import javax.swing.*;
import java.math.BigInteger;

public class ConstructProductMatrix {
    public static void main(String[] args) {
        ConstructProductMatrix obj = new ConstructProductMatrix();
        //display(obj.constructProductMatrix(new int[][]{{1,2}, {3,4}}));
        //display(obj.constructProductMatrix(new int[][]{{12345}, {2}, {1}}));
        display(obj.constructProductMatrix(new int[][]{{10,20},{18,16},{17,14},{16,9},{14,6},{16,5},{14,8},{20,13},{16,10},{14,17}}));
    }


    private static void display(int[][] ints) {
        for (int[] i : ints) {
            for (int ii : i) {
                System.out.print(ii + " ");
            }
            System.out.println();
        }
    }

    private static void display(long[][] ints) {
        for (long[] i : ints) {
            for (long ii : i) {
                System.out.print(ii + " ");
            }
            System.out.println();
        }
    }
    /*
    1 2 3    6 3 2
    4 5 6    30 24 20
     */

    public int[][] constructProductMatrix(int[][] grid) {
        long[][] temp = new long[grid.length][grid[0].length];
        long[] maxmul = new long[grid.length];
        long[] maxmulMain = new long[grid.length];
        int[][] result = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int size = grid[i].length;
            temp[i][0] = 1;
            for (int j = 1; j < size; ++j) {
                temp[i][j] = (temp[i][j - 1] * grid[i][j - 1]) % 12345;
            }
            long mul = grid[i][size - 1];
            for (int index = size - 2; index >= 0; index--) {
                temp[i][index] = (temp[i][index] * mul) % 12345;
                mul = (mul * grid[i][index]) % 12345;
            }

            maxmul[i] = (temp[i][size - 1] * grid[i][size - 1]) % 12345;
        }
        


        maxmulMain[0] = 1;
        for (int j = 1; j < maxmul.length; ++j) {
            maxmulMain[j] = (maxmulMain[j - 1] * maxmul[j - 1]) % 12345;
        }
        long mul = maxmul[maxmul.length - 1];
        for (int index = maxmul.length - 2; index >= 0; index--) {
            maxmulMain[index] = (maxmulMain[index] * mul) % 12345;
            mul = (mul * maxmul[index]) % 12345;
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; ++j) {
                result[i][j] = (int)((temp[i][j] * maxmulMain[i]) % 12345);
            }
        }

        return result;
    }
}
