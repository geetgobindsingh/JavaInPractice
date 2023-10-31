package pepcoding.recursion;

public class MaxOfArray {
    public static void main(String[] args) {
        int ar[] = new int[]{4, 3, 2, 1, 5};
        System.out.print(maxOfArray(ar, 0, -1));
    }

    private static int maxOfArray(int[] ar, int i, int max) {
        if (i == ar.length) return max;
        return maxOfArray(ar, i + 1, Math.max(ar[i], max));
    }


}
