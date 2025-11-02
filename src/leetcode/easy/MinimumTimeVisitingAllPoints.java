package leetcode.easy;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints obj = new MinimumTimeVisitingAllPoints();
        System.out.println(obj.minTimeToVisitAllPoints(new int[][]{
                {1, 1}, {3, 4}, {-1, 0}
        }));
        System.out.println(obj.minTimeToVisitAllPoints(new int[][]{
                {3, 2}, {-2, 2}
        }));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            ans += Math.max(dx, dy);
        }
        return ans;
    }
}
