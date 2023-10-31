package gfg.amazonprep.dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{2, 3, 5, 6};
        int numberOfCoins = coins.length;
        int value = 10;
        System.out.print(minimumNumberOfCoins2(coins, numberOfCoins, value));
    }

    public static long minimumNumberOfCoins(int coins[], int numberOfCoins, int value) { //dp
        if (coins.length == 0) {
            return -1;
        }
        if (coins.length == 1) {
            return coins[0] != value ? -1 : 1;
        }

        int n = coins.length + 1;
        int m = value + 1;

        long[][] matrix = new long[n][m];

        for (int i = 0; i < m; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (value % coins[j] == 0) {

                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        return 0;
    }

    public static long minimumNumberOfCoins2(int coins[], int numberOfCoins, int value) { //recursion
        long matrix[] = new long[value + 1];
        return minimumNumberOfCoinsDp(coins, numberOfCoins, value, matrix);
    }

    public static long minimumNumberOfCoinsDp(int coins[], int numberOfCoins, int value, long matrix[]) { //dp
        long min = Long.MAX_VALUE;
        if (value == 0) {
            return 0;
        }
        if (value < 0) {
            return -1;
        }
        for (int i = 0; i < numberOfCoins; i++) {
            if (value % coins[i] == 0) {
                int count = value / coins[i];
                int newVal = value - (count * coins[i]);
                long result = 0;
                if (newVal >= 0) {
                    if (matrix[newVal] != 0) {
                        result = matrix[newVal];
                    } else {
                        result = minimumNumberOfCoinsDp(coins, numberOfCoins, newVal, matrix);
                        matrix[newVal] = result;
                    }
                } else {
                    result = -1;
                }
                min = Math.min(min, (result < 0) ? Long.MAX_VALUE : count + result);
            } else {
                int newVal = value - coins[i];
                long result = 0;
                if (newVal >= 0) {
                    if (matrix[newVal] != 0) {
                        result = matrix[newVal];
                    } else {
                        result = minimumNumberOfCoinsDp(coins, numberOfCoins, newVal, matrix);
                        matrix[newVal] = result;
                    }
                } else {
                    result = -1;
                }
                min = Math.min(min, (result < 0) ? Long.MAX_VALUE : 1 + result);
            }
        }
        if (min == Long.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public static long minimumNumberOfCoinsR(int coins[], int numberOfCoins, int value) { //recursion
        long min = Long.MAX_VALUE;
        if (value == 0) {
            return 0;
        }
        if (value < 0) {
            return -1;
        }
        for (int i = 0; i < numberOfCoins; i++) {
            if (value % coins[i] == 0) {
                int count = value / coins[i];
                long result = minimumNumberOfCoinsR(coins, numberOfCoins, value - (count * coins[i]));
                min = Math.min(min, (result < 0) ? Long.MAX_VALUE : count + result);
            } else {
                long result = minimumNumberOfCoinsR(coins, numberOfCoins, value - (coins[i]));
                min = Math.min(min, (result < 0) ? Long.MAX_VALUE : 1 + result);
            }
        }
        if (min == Long.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
