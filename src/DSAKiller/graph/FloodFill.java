package DSAKiller.graph;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] flooded = floodFill(image, 0, 0, 2);
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image.length; y++) {
                System.out.print(flooded[x][y] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }

    public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int startingPixesColor = image[sr][sc];
        image[sr][sc] = newColor;
        for (int step = 0; step < 4; step++) {
            int x = sr + dx[step];
            int y = sc + dy[step];
            if (x < image.length && y < image.length
                    && x >= 0 && y >= 0
                    && image[x][y] == startingPixesColor) {
                floodFill2(image, x, y, newColor);
            }
        }
        return image;
    }
}
