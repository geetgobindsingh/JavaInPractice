package gfg.amazonprep.recursion;

import java.util.*;

public class PowerLogarithmic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(power(sc.nextInt(), sc.nextInt()));
    }

    private static int power(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        int xpnby2 = power(x, n/2);
        int xn = xpnby2 * xpnby2;
        if (n/2 == 1) {
            xn*=x;
        }
        return xn;
    }
}
