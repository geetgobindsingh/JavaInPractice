package random;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Created by geetgobindsingh on 09/09/17.
 */
public class LinkedhashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> str  = new LinkedHashSet<>();
        str.add("1");
        str.add("2");
        str.add("1");
        for(String st : str) {
            System.out.println(st);
        }

        ArrayList<String> atr = new ArrayList<>();
        atr.add("a");
        atr.add("b");
        atr.add("c");
        atr.add("a");

        str = new LinkedHashSet<>(atr);
        for(String st : str) {
            System.out.println(st);
        }

        ArrayList<String> aar = new ArrayList<>();
        aar = null;
        if(aar == null) {
            System.out.println("aar is null");
        } else {
            for (String st : aar) {
                System.out.println(st);
            }
        }
    }
}
