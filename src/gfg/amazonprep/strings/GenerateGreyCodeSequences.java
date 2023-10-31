package gfg.amazonprep.strings;

import java.util.ArrayList;
import java.util.Collections;

public class GenerateGreyCodeSequences {
    public static void main(String[] args) {
        for (String s : generateCode(2)) {
            System.out.print(s + " ");
        }
    }

    public static ArrayList<String> generateCode(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("0");
            result.add("1");
            return result;
        }
        ArrayList<String> res = generateCode(n - 1);
        for (int i = 0; i < 2; i++) {
            for (String ss : res) {
                result.add(String.valueOf(i) + ss);
            }
            Collections.reverse(res); // Grey Code ka Exception
        }
        return result;
    }

}
