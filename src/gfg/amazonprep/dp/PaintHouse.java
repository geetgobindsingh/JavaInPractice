package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-official/ojquestion
public class PaintHouse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] ar = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(ar[j]);
            }
        }
        System.out.print(findMinCostOfPainting(n, matrix));
    }

    //right solution
    private static long findMinCostOfPainting(int n, int[][] matrix) {
        long minRedCost = matrix[0][0];
        long minBlueCost = matrix[0][1];
        long minGreenCost = matrix[0][2];
        for (int i = 1; i < n; i++) {
            long newMinRedCost = matrix[i][0] + Math.min(minBlueCost, minGreenCost);
            long newMinBlueCost = matrix[i][1] + Math.min(minRedCost, minGreenCost);
            long newMinGreenCost = matrix[i][2] + Math.min(minBlueCost, minRedCost);
            minRedCost = newMinRedCost;
            minBlueCost = newMinBlueCost;
            minGreenCost = newMinGreenCost;
        }
        long min = minRedCost;
        if (min > minBlueCost) {
            min = minBlueCost;
        }
        if (min > minGreenCost) {
            min = minGreenCost;
        }
        return min;
    }

    // below is a wrong solution because it is afected by the order of colors passed
    static class LastSelectedHouse {
        int totalMinCost = 0;
        int selectedColorIndex = -2;
    }

    private static int findMinCostOfPainting1(int n, int[][] matrix) {
        LastSelectedHouse selectedHouse = new LastSelectedHouse();
        for (int i = 0; i < n; i++) {
            updateSelectedHouse(selectedHouse, i, matrix);
        }
        return selectedHouse.totalMinCost;
    }

    private static void updateSelectedHouse(LastSelectedHouse selectedHouse, int index, int[][] matrix) {
        int selectedIndex = -1;
        int minCost = Integer.MAX_VALUE;
        if (0 != selectedHouse.selectedColorIndex) {
            minCost = matrix[index][0];
            selectedIndex = 0;
        }
        if (minCost >= matrix[index][1] && 1 != selectedHouse.selectedColorIndex) {
            minCost = matrix[index][1];
            selectedIndex = 1;
        }
        if (minCost >= matrix[index][2] && 2 != selectedHouse.selectedColorIndex) {
            minCost = matrix[index][2];
            selectedIndex = 2;
        }
        selectedHouse.totalMinCost += minCost;
        selectedHouse.selectedColorIndex = selectedIndex;
    }

}
