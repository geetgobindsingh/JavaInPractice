package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//https://www.youtube.com/watch?v=_c_R-uIi-zU&feature=emb_logo&ab_channel=Pepcoding
public class TilingWithMX1Tiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        System.out.print(numberOfWaysFloorCanBeTiledUsingTiles(n, m));
    }

    // Same as fibonacci
    private static long numberOfWaysFloorCanBeTiledUsingTiles(int n, int m) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }

}
