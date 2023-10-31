package gfg.amazonprep.dp;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    // Array
    public static int maxProfit(int[] prices) {
        int maxIndex = prices.length - 1;
        int minIndex = -1;
        for (int i = (prices.length - 1); i >= 0; i--) {
            if (minIndex != -1) {
                if (prices[i] > prices[maxIndex] && i < minIndex) {
                    maxIndex = i;
                }
            } else {
                if (prices[i] > prices[maxIndex]) {
                    maxIndex = i;
                }
            }

            if (minIndex != -1 && prices[i] < prices[minIndex]) {
                minIndex = i;
            } else {
                minIndex = i;
            }
        }
        return prices[maxIndex] - prices[minIndex];
    }

    // Dp
    public static int maxProfit2(int[] prices) {
        int max = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = (prices.length - 1); i >= 0; i--) {
            maxValue = Math.max(maxValue, prices[i]);
            max = Math.max(max, maxValue - prices[i]);
        }
        return Integer.max(max, 0);
    }

    // BruteForce
    public static int maxProfit1(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff >= 0) {
                    max = Integer.max(max, diff);
                }
            }
        }
        return Integer.max(max, 0);
    }
}
