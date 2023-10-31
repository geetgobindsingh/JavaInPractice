package gfg.amazonprep.dp;

public class EggDroppingPuzzle {
    public static void main(String[] args) {
        System.out.print(eggDrop(3, 5));
    }

    public static int eggDrop(int n, int k) {
        if (k <= n) {
            return 1;
        }
        return 1 + eggDrop(n, (int) Math.pow(k, 1.0 / n));
    }
}
