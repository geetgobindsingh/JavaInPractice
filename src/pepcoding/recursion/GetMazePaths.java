package pepcoding.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetMazePaths {
    /*
    You are standing in the top-left corner and have to reach the bottom-right corner.
    Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
    Input:
    3
    3
    Output:
    [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());

        System.out.print(getMazePaths(0, 0, rows - 1, cols - 1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    private static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // base condition
        if (sr == dr && sc == dc) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        } else if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> hPaths = getMazePaths(sr, sc + 1, dr, dc);
        for (String path : hPaths) {
            result.add("h" + path);
        }
        ArrayList<String> vPaths = getMazePaths(sr + 1, sc, dr, dc);
        for (String path : vPaths) {
            result.add("v" + path);
        }
        return result;
    }
}
