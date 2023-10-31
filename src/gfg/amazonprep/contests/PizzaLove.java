package gfg.amazonprep.contests;

public class PizzaLove {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 4, 5};
        System.out.print(maxPizza(ar.length, ar));
        ar = new int[]{5, 3, 4, 11, 2};
        System.out.print(maxPizza(ar.length, ar));
    }

    public static int maxPizza(int n, int[] arr) {
        if (n < 1) {
            return -1;
        }
        if (n < 2) {
            return arr[0];
        }
        if (n < 3) {
            return Math.max(arr[0], arr[1]);
        }
        int max[] = new int[n];
        max[0] = arr[0];
        max[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            max[i] = Math.max(arr[i] + max[i - 2], max[i - 1]);
        }
        return max[n - 1];
    }
}
