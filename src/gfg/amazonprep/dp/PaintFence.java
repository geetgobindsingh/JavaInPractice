package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: @Difficult @Interesting
//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-fence-official/ojquestion
public class PaintFence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.println(numberOfWaysFencePainting(n, k));
    }

    private static int numberOfWaysFencePainting(int n, int k) {
        int same = k * 1;
        int diff = k * (k - 1);
        int total = same + diff;
        for (int i = 2; i < n; i++) {
            same = diff * 1;
            diff = total * (k -1);
            total = same + diff;
        }
        return total;
    }
}
