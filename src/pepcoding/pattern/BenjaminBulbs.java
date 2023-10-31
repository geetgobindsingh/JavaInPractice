package pepcoding.pattern;

import java.io.*;

public class BenjaminBulbs {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int n = Integer.parseInt(br.readLine());
        printAllONBulbPositions(n);
        System.out.println();
        printPerfectSquare(n);
    }

    private static void printPerfectSquare(int n) {
        for (int i = 1; i * i <= n; i++) {
            System.out.println(i*i);
        }
    }

    private static void printAllONBulbPositions(int n) {
        boolean ar[] = new boolean[n];
        for (int wave = 1; wave <= n; wave++) {
            int index = 0;
            while (index < n) {
                if ((index + 1) % wave == 0) {
                    ar[index] = !ar[index];
                }
                if (wave == n && ar[index]) {
                    System.out.println(index + 1);
                }
                index++;
            }
        }
    }

    private static void printAllBulbPositionsDebug(int n) {
        boolean ar[] = new boolean[n];
        for (int wave = 1; wave <= n; wave++) {
            int index = 0;
            while (index < n) {
                if ((index + 1) % wave == 0) {
                    ar[index] = !ar[index];
                }
                System.out.print((ar[index] ? "1" : "0")  + " ");
                index++;
            }
            System.out.println();
        }
    }


}
