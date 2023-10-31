package practice;

public class Goodies {
    public static void main(String[] args) {
        int[] goodies = new int[]{3, 6, 7, 11};
        int h = 8;
        System.out.print(getMinSpeed(goodies, goodies.length, h));
    }

    private static int getMinSpeed(int[] goodies, int length, int h) {
        if (h < length) {
            return -1;
        }

        int low = 1, high = findmax(goodies);

        while (low < high) {
            int mi = low + (high - low) / 2;
            if (!isPossible(goodies, length, h, mi)) {
                low = mi + 1;
            } else {
                high = mi;
            }
        }

        return low;
    }

    private static boolean isPossible(int[] goodies, int length, int h, int K) {
        int time = 0;
        for (int i = 0; i < length; ++i) {
            time += (goodies[i] - 1) / K + 1;
        }
        return time <= h;
    }

    private static int findmax(int[] goodies) {
        int max = goodies[0];
        for (int i = 1; i < goodies.length; i++) {
            max = Math.max(max, goodies[i]);
        }
        return max;
    }
}
