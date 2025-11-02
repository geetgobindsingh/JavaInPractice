package leetcode.easy;

import java.util.HashSet;

public class PathCrossing {
    public static void main(String[] args) {
        PathCrossing obj = new PathCrossing();
//        System.out.println(obj.isPathCrossing("NES"));
//        System.out.println(obj.isPathCrossing("NESW"));
//        System.out.println(obj.isPathCrossing("NESWW"));
        System.out.println(obj.isPathCrossing("SSSWNNWNENNNWWNNNENNNNNWNNNNWNWSWWWSWWWNWSWSW"));
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point nextPoint(char c) {
            if (c == 'N') {
                y = y + 1;
            } else if (c == 'E') {
                x = x + 1;
            } else if (c == 'W') {
                x = x - 1;
            } else if (c == 'S') {
                y = y - 1;
            }
            return this;
        }

        public int getKey() {
            return x * 7 + y * 17;
        }
    }

    public boolean isPathCrossing(String path) {
        Point p = new Point(0, 0);
        HashSet<Integer> set = new HashSet<>();
        set.add(p.getKey());
        System.out.println(p.x + ", " + p.y);
        for (char c : path.toCharArray()) {
            p = p.nextPoint(c);
            System.out.println(p.x + ", " + p.y);
            if (!set.add(p.getKey())) {
                return true;
            }
        }
        return false;
    }
}
