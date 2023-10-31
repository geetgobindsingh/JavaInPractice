package gfg.amazonprep.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    public static void main(String[] args) {
        String[] sr = "778 887 794 916 336 387 493 650 363 422 28 691 60 764 541 927 173 427 212 737 369 568 430 783 531 863 68 124 136 930 23 803 59 70 168 394 12 457 43 230 374 422 785 920 199 538 316 325 371 414 92 527 957 981 863 874 171 997 282 306 85 926 328 337 506 847 314 730".split(" ");
        Pair arr[] = new Pair[sr.length / 2];
        int k = 0;
        for (int i = 0; i < sr.length; i = i + 2) {
            arr[k++] = new Pair(Integer.parseInt(sr[i]), Integer.parseInt(sr[i + 1]));
            System.out.print("(" + sr[i] + "," + sr[i + 1] + ")");
        }
        System.out.print("\n");
        int result = maxChainLength(arr, arr.length);
        System.out.print(result);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int maxChainLength(Pair[] arr, int n) {
        if (arr.length == 0 || arr.length == 1) return 1;
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        int[] matrix = new int[n];
        matrix[n - 1] = 1;
        int maxLength = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            Pair p = arr[i];
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (p.y < arr[j].x) {
                    max = Math.max(max, matrix[j]);
                }
            }
            matrix[i] = 1 + ((max == Integer.MIN_VALUE) ? 0 : max);
            maxLength = Math.max(maxLength, matrix[i]);
        }
        for (int i : matrix) {
            System.out.print(i + "      ");
        }
        System.out.print("\n");
        return maxLength;
    }
}
