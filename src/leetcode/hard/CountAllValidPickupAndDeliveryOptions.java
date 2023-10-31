package leetcode.hard;

public class CountAllValidPickupAndDeliveryOptions {
    public static void main(String[] args) {
        CountAllValidPickupAndDeliveryOptions obj = new CountAllValidPickupAndDeliveryOptions();
//        for (int i = 3; i < 10; i++) {
//            System.out.println(i + " -> " + obj.countOrders(i));
//        }
        int i = 8;
        System.out.println(i + " -> " + obj.countOrders(i));
        System.out.println(i + " -> " + obj.countOrders2(i));
    }

    public int countOrders(int n) {
        final int mod = (int) 1e9 + 7;
        long f = 1;
        for (int i = 2; i <= n; ++i) {
            f = f * i * (2 * i - 1) % mod;
        }
        return (int) f;
    }
    public int countOrders2(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int mod = 1000_000_000 + 7;
        for (int i = 1; i <= n; i++) {
            dp[i] = (i * ((2*i) - 1) * dp[i - 1]) % mod;
        }
        return (int) dp[n];
    }


}
