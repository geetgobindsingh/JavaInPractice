package leetcode.medium;

public class ChampagneTower {
    public static void main(String[] args) {

        ChampagneTower obj = new ChampagneTower();
        System.out.println(obj.champagneTower(1,1,1));
        System.out.println(obj.champagneTower(2,1,1));
        System.out.println(obj.champagneTower(100000009,33,17));
        System.out.println(obj.champagneTower(25,6,1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) { // best solution
        double[] glasses = new double[100+1];
        glasses[0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int g = i; g >= 0; g--) {
                double overflow = glasses[g] - 1;
                double half = overflow * 0.5;
                if(overflow > 0){
                    glasses[g] = half;
                    glasses[g + 1] = glasses[g + 1] + half;
                } else {
                    glasses[g] = 0;
                    glasses[g + 1] = glasses[g + 1] + 0;
                }
            }
        }
        if(glasses[query_glass] > 1){
            return 1;
        } else{
            return glasses[query_glass];
        }
    }

    public double champagneTower3(int poured, int query_row, int query_glass) { // good solution
        double[][] glasses = new double[100+1][100+1];
        glasses[0][0] = poured;
        for (int i = 0; i < (query_row + 1); i++) { // +1 in row row toh handle overlflow
            for (int g = 0; g <= i; g++) {
                if (glasses[i][g] > 1) {
                    double overflow = glasses[i][g] - 1;
                    glasses[i][g] = 1;
                    double half = overflow * 0.5;
                    glasses[i + 1][g] = glasses[i + 1][g] + half;
                    glasses[i + 1][g + 1] = glasses[i + 1][g + 1] + half;
                }
            }
        }
        return glasses[query_row][query_glass];
    }
    public double champagneTower2(int poured, int query_row, int query_glass) { // not working
        int minPossible = getMin(query_row);
        boolean belowMin = minPossible >= poured;
        int maxPossible = minPossible + (2 * query_row);
        boolean aboveMax = (maxPossible) < poured;
        if (aboveMax) {
            return 1.0;
        }
        if (belowMin) {
            return 0.0;
        }
        int remain = poured - minPossible;
        double filled = (double) 1 / (double) (query_row);
        if (query_glass == 0 || query_glass == query_row) {
            return remain * filled * 0.5;
        } else {
            return remain * filled;
        }
    }

    public int getMin(int row) {
        if (row == 0) return 0;
        if (row == 1) return 1;
        if (row == 2) return 3;
        if (row == 3) return 5;
        int minPossible = 3;
        for (int i = 2; i < row; i++) {
            minPossible = minPossible + i;
        }
        return minPossible;
    }



}
