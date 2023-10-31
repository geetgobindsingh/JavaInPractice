package gfg.amazonprep.dp;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Envelop[] envelops = new Envelop[n];
        for (int i = 0; i < n; i++) {
            String[] ar = br.readLine().split(" ");
            envelops[i] = new Envelop(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]));
        }
        System.out.println(maximumNumberOfEnvelopesThatCanBeNestedInsideEachOther(n, envelops));
    }

    private static long maximumNumberOfEnvelopesThatCanBeNestedInsideEachOther(int n, Envelop[] envelops) {
        Arrays.sort(envelops);
        int maxLength = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (envelops[j].height <= envelops[i].height) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }

    static class Envelop implements Comparable<Envelop> {
        public final int width;
        public final int height;

        public Envelop(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(@NotNull Envelop o) {
            if (this.width == o.width) {
                return Integer.compare(this.height, o.height);
            } else {
                return Integer.compare(this.width, o.width);
            }
        }
    }

}
