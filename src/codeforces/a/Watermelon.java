package codeforces.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        System.out.print(((w>2) && (w % 2 == 0)) ? "YES" : "NO");
    }
}
