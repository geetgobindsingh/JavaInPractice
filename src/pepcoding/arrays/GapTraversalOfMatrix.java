package pepcoding.arrays;

public class GapTraversalOfMatrix {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        for (int gap = 0; gap < matrix.length; gap++) {
            for (int i = 0, j = gap; j < matrix.length; i++, j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
