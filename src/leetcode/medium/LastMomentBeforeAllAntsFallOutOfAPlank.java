package leetcode.medium;

public class LastMomentBeforeAllAntsFallOutOfAPlank {
    public static void main(String[] args) {
        LastMomentBeforeAllAntsFallOutOfAPlank obj = new LastMomentBeforeAllAntsFallOutOfAPlank();
        System.out.println(obj.getLastMoment(4, new int[]{4,3}, new int[]{0,1}));
        System.out.println(obj.getLastMoment(7, new int[]{}, new int[]{0,1,2,3,4,5,6,7}));
        System.out.println(obj.getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{}));
        System.out.println(obj.getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{0,1,2,3,4,5,6,7}));
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = 0;
        int rightMin = n;

        for (int l : left) {
            leftMax = Math.max(leftMax, l);
        }
        for (int r : right) {
            rightMin = Math.min(rightMin, r);
        }

        return Math.max(leftMax, n - rightMin);
    }
}
