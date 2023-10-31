package leetcode.medium;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println(shipWithinDays(new int[]{10, 50, 100, 100, 50, 100, 100, 100}, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight = totalWeight + weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        int l = maxWeight;
        int r = totalWeight;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid, weights, days)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static boolean check(int perDay, int[] weights, int days) {
        int totalDays = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum = sum + weights[i];
            if (sum > perDay) {
                totalDays++;
                sum = 0;
                i = i - 1;
            }
        }
        return totalDays >= days;
    }
}
