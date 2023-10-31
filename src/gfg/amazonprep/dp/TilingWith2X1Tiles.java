package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.youtube.com/watch?v=dVT9JeUMMDE&feature=emb_logo&ab_channel=Pepcoding
public class TilingWith2X1Tiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(numberOfWaysFloorCanBeTiledUsingTiles(n));
    }

    // Same as fibonacci
    private static long numberOfWaysFloorCanBeTiledUsingTiles(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
