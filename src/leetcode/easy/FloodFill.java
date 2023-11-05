package leetcode.easy;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        display(obj.floodFill(new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        }, 1, 1, 2));
        display(obj.floodFill(new int[][]{
                {0, 0, 0}, {0, 0, 0}, {0, 0, 0}
        }, 0, 0, 0));
    }

    private static void display(int[][] nums) {
        for (int i = 0 ; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        return dfs(image, sr, sc, startColor, color);
    }

    public int[][] dfs(int[][] image, int sr, int sc, int init, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == color) {
            return image;
        }
        if (image[sr][sc] == init) {
            image[sr][sc] = color;
            dfs(image, sr + 1, sc, init, color);
            dfs(image, sr, sc + 1, init, color);
            dfs(image, sr, sc - 1, init, color);
            dfs(image, sr - 1, sc, init, color);
        }
        return image;
    }
}
