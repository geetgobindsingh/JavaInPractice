package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: @Difficult @Interesting
public class CountAplusBplusCplusSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.length() > 0 && input.length() <= 10) {
            System.out.println(countSubsequences(input));
        }
    }

    private static int countSubsequences(String input) {
        int a = 0;
        int ab = 0;
        int abc = 0;
        for (int i =0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                a = a + a + 1;  // a + a' + aa'
            } else if (input.charAt(i) == 'b') {
                ab = ab + ab + a;  // ab + aba' + abb' + aa'b' + a'b'
            } else if (input.charAt(i) == 'c') {
                abc = abc + abc + ab; // abc + abc' + abcc' + abb'c' + aa'b'c' + + ab'c' + a'b'c'
            }
        }
        return abc;
    }
}
