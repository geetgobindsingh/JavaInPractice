package gfg.amazonprep.dp;


public class nCr {
    public static void main(String[] args) {
        System.out.print(nCrModp(84, 56));
    }

    // function to find nC
    public static int nCrModp(int n, int r) {
        if (r > n) return 0;
        java.math.BigInteger map[] = new java.math.BigInteger[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new java.math.BigInteger("0");
        }
        java.math.BigInteger factN = fact(n, map);
        java.math.BigInteger factR = fact(r, map);
        java.math.BigInteger factNminusR = fact((n - r), map);
        java.math.BigInteger result = (factN.divide(factR.multiply(factNminusR)));
        return result.mod(new java.math.BigInteger(String.valueOf((int) Math.pow(10, 9) + 7))).intValue();
    }

    public static java.math.BigInteger fact(int n, java.math.BigInteger map[]) {
        if (n == 1 || n == 0) {
            return new java.math.BigInteger("1");
        }
        if (!map[n].equals(new java.math.BigInteger("0"))) {
            return map[n];
        }
        map[n] = fact(n - 1, map).multiply(new java.math.BigInteger(String.valueOf(n)));
        return map[n];
    }
}
