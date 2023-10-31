package gfg.amazonprep.strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PrintAllPossibleStrings {
    public static void main(String[] args) {
        for (String s : spaceString("abc")) {
            System.out.println(s + " ");
        }
    }

    public static ArrayList<String> spaceString(String str) {
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
        return permute(str, map);
    }

    public static ArrayList<String> permute(String str, LinkedHashMap<String, ArrayList<String>> map) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 1) {
            list.add(str);
            map.put(str, list);
            return map.get(str);
        }
        list.add(str);
        for (int i = str.length() - 1; i >= 1; i--) {
            ArrayList<String> sublist = permute(str.substring(i), map);
            for (String s : sublist) {
                list.add(str.substring(0, i) + " " + s);
            }
        }
        map.put(str, list);
        return map.get(str);
    }


    public static ArrayList<String> permute2(String str, LinkedHashMap<String, ArrayList<String>> map) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 1) {
            list.add(str);
            map.put(str, list);
            return map.get(str);
        }
        list.add(str);
        for (int i = 1; i < str.length(); i++) {
            ArrayList<String> sublist = permute(str.substring(i), map);
            for (String s : sublist) {
                list.add(str.substring(0, i) + " " + s);
            }
        }
        map.put(str, list);
        return map.get(str);
    }

}
