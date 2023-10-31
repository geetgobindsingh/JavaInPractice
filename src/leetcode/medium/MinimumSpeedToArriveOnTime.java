package leetcode.medium;

import java.text.DecimalFormat;

public class MinimumSpeedToArriveOnTime {
    public static void main(String[] args) {
        System.out.println(1e1);
        System.out.println(1e7);
        System.out.println(10_000_000);
        System.out.println(1e7 == 10_000_000);
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        System.out.println(minSpeedOnTime(new int[]{1, 1, 100000}, 2.01));
        System.out.println(minSpeedOnTime(new int[]{5, 3, 4, 6, 2, 2, 7}, 10.92));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int low = 0;
        int high = 10_000_000;
        int result = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (isValid(dist, mid, hour)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid(int[] dist, int speed, double hour) {
        double hourObserved = 0.0;
        int i = 0;
        for (; i < dist.length - 1; i++) {
            if ((hourObserved > hour)) {
                return false;
            }
            hourObserved = hourObserved + Math.ceil((double) dist[i] / speed);
        }
        hourObserved = hourObserved + (double) dist[i] / speed;
        //System.out.println("speed " + speed +  " hourObserved " + hourObserved + " - target " + hour);
        return (hourObserved <= hour);
    }

    public static int WRONG(int[] dist, double hour) {
        int n = dist.length;
        int maxTimeBeforeLastStation = n - 1;
        double dif = hour - maxTimeBeforeLastStation;
        if (dif < 0) {
            return -1;
        }

        double result = (((double) dist[n - 1]) / dif);
        DecimalFormat df = new DecimalFormat("#.00");
        result = Double.valueOf(df.format(result));
        System.out.print(result + " ");
        int x = (int) Math.ceil(result);
        if (x > 0) {
            return x;
        }
        return -1;
    }
}
