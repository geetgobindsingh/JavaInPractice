package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/arrange-buildings-official/ojquestion
public class ArrangeBuildings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (0 < n && n <= 45) {
            System.out.print(numberOfBuildingWays(n));
        }
    }

     /*
    in: 6
    out : 441
     */

    private static int numberOfBuildingWays(int n) {
        if (n == 0) return 0;
        int numberOfBuildings = 1;
        int numberOfSpaces = 1;
        for (int i = 2; i <= n; i++) {
            int numBuilding = numberOfSpaces;
            int numSpace = numberOfBuildings + numberOfSpaces;
            numberOfBuildings = numBuilding;
            numberOfSpaces = numSpace;
        }
        return (int) Math.pow(numberOfSpaces + numberOfBuildings, 2);
    }


}
