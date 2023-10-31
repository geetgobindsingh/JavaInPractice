package leetcode.medium;

public class MinPenaltyForAShop {
    public static void main(String[] args) {
        MinPenaltyForAShop obj = new MinPenaltyForAShop();
        System.out.println(obj.bestClosingTime("YYNY"));
        System.out.println(obj.bestClosingTime("NNNNN"));
        System.out.println(obj.bestClosingTime("YYYY"));
        System.out.println(obj.bestClosingTime("NYNNNYYN"));
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pn = new int[n + 1];
        int nc = 0;
        for (int i = 0; i < n; i++) {
            pn[i] = nc;
            if (isN(customers, i)) {
                nc++;
            }
        }
        pn[n] = nc;
        int nyc = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (isY(customers, i)) {
                nyc++;
            }
            pn[i] += nyc;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i <= n; i++) {
            if (pn[i] < min) {
                min = pn[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public boolean isN(String customers, int i) {
        return customers.charAt(i) == 'N';
    }

    public boolean isY(String customers, int i) {
        return customers.charAt(i) == 'Y';
    }
}
