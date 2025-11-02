package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfWaysToDivideALongCorridor {
    public static void main(String[] args) {
        NumberOfWaysToDivideALongCorridor obj = new NumberOfWaysToDivideALongCorridor();
        System.out.println(obj.numberOfWays("SSPPSPS"));
        System.out.println(obj.numberOfWays("SSSPPPSPPSPSSSSSSPPPSPP"));
        //SSSPPPSPPSPSSSSSSPPPSPP
        //ss sppps pp sps ss ss sppps pp
        //1 + 3 + 1 + 1 + 0 = 6
        //0 + 3 + 0
        System.out.println(obj.numberOfWays("PPSPPSSSSSSSPSPS"));
        // PP SPPS SS SS SS P SPS
        // 0 + 2
        System.out.println(obj.numberOfWays("PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS"));
    }

    private String s;
    private int n;
    private int[][] f;
    private static final int MOD = (int) 1e9 + 7;

    public int numberOfWays(String corridor) {
        s = corridor;
        n = s.length();
        f = new int[n][3];
        for (int[] e : f) {
            Arrays.fill(e, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int cnt) {
        if (i == n) {
            return cnt == 2 ? 1 : 0;
        }
        cnt += s.charAt(i) == 'S' ? 1 : 0;
        if (cnt > 2) {
            return 0;
        }
        if (f[i][cnt] != -1) {
            return f[i][cnt];
        }
        int ans = dfs(i + 1, cnt);
        if (cnt == 2) {
            ans += dfs(i + 1, 0);
            ans %= MOD;
        }
        f[i][cnt] = ans;
        return ans;
    }
    public int numberOfWays1(String corridor) { // wrong answer
        int mod = 1000_000_007;
        long seatCount = 0;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);
            if (c == 'S') { seatCount++; }
            if (seatCount % 2 == 0 && c == 'P') {
                int startIndex = i;
                int endIndex = i;
                while (endIndex < corridor.length() && corridor.charAt(endIndex) == 'P') {
                    endIndex++;
                }
                if (startIndex != 0 && endIndex != corridor.length()) {
                    list.add(new Integer[]{startIndex, endIndex});
                }
                i = endIndex - 1;
            }
        }
        if (seatCount % 2 == 1) {
            return 0;
        }
        if (seatCount < 2) return 0;
        if (seatCount == 2) return 1;

        int count = 1;
        for (Integer[] pair : list) {
            count = (count * (pair[1] - pair[0] + 1)) % mod;
        }

        return count;
    }
}
