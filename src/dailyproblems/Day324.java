package dailyproblems;

import java.util.Arrays;

public class Day324 {

    /*
    This problem was asked by Amazon.

    Consider the following scenario:
    there are N mice and N holes placed at integer points along a line.
    Given this, find a method that maps mice to holes such that the largest number of steps any mouse takes is minimized.

    Each move consists of moving one mouse one unit to the left or right, and only one mouse can fit inside each hole.

    For example, suppose the mice are positioned at [1, 4, 9, 15],
     and the holes are located at [10, -5, 0, 16]. In this case,
     the best pairing would require us to send the mouse at 1 to the hole at -5, so our function should return 6
     */
    public static void main(String[] args) {
        int[] micePosition = new int[]{1, 4, 9, 15};
        int[] holePosition = new int[]{10, -5, 0, 16};

        System.out.println(getMinStepsTaken(micePosition, holePosition));
    }

    private static int getMinStepsTaken(int[] micePosition, int[] holePosition) {
        Arrays.sort(micePosition);
        Arrays.sort(holePosition);
        int min = 0;
        for (int index = 0; index < micePosition.length; ++index) {
            min = Math.max(min, Math.abs(micePosition[index] - holePosition[index]));
        }
        return min;
    }
}
