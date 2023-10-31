package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ota-official/ojquestion
public class BuyAndSellStocksOneTransactionAllowed {
    //You are required to print the maximum profit you can make if you are allowed a single transaction.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(getMaxProfit(n, ar));
    }

    private static long getMaxProfit(int n, int[] price) {
        int maxProfit = 0;
        int leastPrice = Integer.MAX_VALUE;
        int todayProfit = 0;
        for (int i = 0; i < n; i++) {
            if (price[i] < leastPrice) {
                leastPrice = price[i];
            }
            todayProfit = price[i] - leastPrice;
            if (todayProfit > maxProfit) {
                maxProfit = todayProfit;
            }
        }
        return maxProfit;
    }

}
