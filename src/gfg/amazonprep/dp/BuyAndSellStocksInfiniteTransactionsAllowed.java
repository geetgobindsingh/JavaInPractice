package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ita-official/ojquestion
public class BuyAndSellStocksInfiniteTransactionsAllowed {
    public static void main(String[] args) throws IOException {

        /*
        You are required to print the maximum profit you can make if you are allowed infinite transactions.
        Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell)
        before opening another transaction (another buy)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(getMaxProfit(n, ar));
    }

    private static long getMaxProfit(int n, int[] price) {
        int profit = 0;
        int buyDate = 0;
        int sellDate = 0;
        for (int i = 0; i < n; i++) {
            if (price[sellDate] <= price[i]) {
                sellDate = i;
            } else {
                profit = profit + (price[sellDate] - price[buyDate]);
                buyDate = sellDate = i;
            }
        }
        //V.V. IMP case: setting last UP
        profit = profit + (price[sellDate] - price[buyDate]);
        return profit;
    }


}
