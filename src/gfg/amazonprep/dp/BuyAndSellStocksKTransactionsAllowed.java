package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-kta---official/ojquestion
public class BuyAndSellStocksKTransactionsAllowed {
    /*
     You are given a number k, representing the number of transactions allowed.
    3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
    Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell)
    before opening another transaction (another buy).
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        System.out.println(getMaxProfit(n, ar, k));
    }

    private static long getMaxProfit(int n, int[] price, int k) {
        int maxProfit = 0;

        return maxProfit;
    }

}
