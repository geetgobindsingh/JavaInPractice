package gfg.amazonprep.dp;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    //Fastest
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int min = prices[0];
        for (int p : prices) {
            if (p > min) {
                res += p - min;
            }
            min = p;
        }
        return res;
    }

    // SLow
    public static int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        int buyIndex = -1;
        int sellIndex = prices.length - 1;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (sellIndex > 0 && prices[i] > prices[sellIndex]) {
                sellIndex = i;
                continue;
            } else {
                if (buyIndex == -1) {
                    buyIndex = i;
                } else if (prices[i] < prices[buyIndex]) {
                    buyIndex = i;
                }
            }
            if (buyIndex < sellIndex) {
                profit += prices[sellIndex] - prices[buyIndex];
                sellIndex = i;
                buyIndex = -1;
            }
        }
        return profit;
    }
}
