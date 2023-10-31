package gfg.amazonprep.strings;

import java.util.ArrayList;

public class GenerateIPAddresses {
    public static void main(String[] args) {
        for (String s : genIp("11211")) {
            System.out.print(s + "");
        }
        for (int g = 0; g < 5; g++) {
            System.out.println("gap : " + g);
            for (int i = 0, j = g; j < 5; i++, j++) {
                System.out.print(i + "-" + j + ", ");
            }
            System.out.println("");
        }
    }

    public static ArrayList<String> genIp(String s) {
        return new ArrayList<>();
    }
}
