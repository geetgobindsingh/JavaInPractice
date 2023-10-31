package gfg.amazonprep.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StringPermutations {
    public static void main(String[] args) {
        System.out.print(permutation("123"));
    }

    public static ArrayList<String> permutation(String S) {
        ArrayList<String> result = new ArrayList<>();
        permute(S.split(""), result, 0, S.length() - 1);
        Collections.sort(result);
        return result;
    }

    public static void permute(String[] s, ArrayList<String> list, int l, int r) {
        if (l == r) {
            list.add(join(s));
        } else {
            for (int i = l; i <= r; i++) {
                swap(s, l, i);
                permute(s, list, l + 1, r);
                swap(s, i, l);
            }
        }
    }

    public static String join(String[] sr) {
        String result = "";
        for (int i = 0; i < sr.length; i++) {
            result = result + sr[i];
        }
        return result;
    }

    public static void swap(String[] sr, int i, int j) {
        String temp = sr[i];
        sr[i] = sr[j];
        sr[j] = temp;
    }

}
