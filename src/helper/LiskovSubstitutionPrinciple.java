package helper;

import java.util.*;

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("b", "aa");
        Collections.sort(list);
        for (String s : (List<String>)list) {
            System.out.println(s);
        }
    }
}
