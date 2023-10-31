package leetcode.medium;

public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        AsFarFromLandAsPossible obj = new AsFarFromLandAsPossible();
        int[][] grid = new int[][] {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        obj.displayArray(grid);
        System.out.print(obj.maxDistance(grid));
    }
    public void displayArray(int[][] ar) {
        for (int[] an : ar) {
            for (int j : an) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public int maxDistance(int[][] grid) {
        return -1;
    }
}
