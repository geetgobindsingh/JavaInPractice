package pepcoding.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class KeyPadCombination {
    public static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        map.put(0, ",;");
        map.put(1, "abc");
        map.put(2, "def");
        map.put(3, "ghi");
        map.put(4, "jkl");
        map.put(5, "mno");
        map.put(6, "pqrs");
        map.put(7, "tu");
        map.put(8, "vwx");
        map.put(9, "yz");

        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.print(getKPCWithMemory(input));
        System.out.print("\n");
        printKPCWithOutMemory(input, "");
    }

    private static ArrayList<String> getKPCWithMemory(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        if (str.length() == 1) {
            ArrayList<String> result = new ArrayList<>();
            String choices = map.get(Integer.parseInt(str));
            for (int i = 0; i < choices.length(); i++) {
                result.add(String.valueOf(choices.charAt(i)));
            }
            return result;
        }

        String choices = map.get(Integer.parseInt(str.substring(0, 1)));
        ArrayList<String> kpcList = getKPCWithMemory(str.substring(1));
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < choices.length(); i++) {
            String choice = String.valueOf(choices.charAt(i));
            for (String kpc : kpcList) {
                result.add(choice + kpc);
            }
        }
        return result;
    }

    private static void printKPCWithOutMemory(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        String remainingQues = ques.substring(1);
        String choices = map.get(Integer.parseInt(ques.substring(0, 1)));
        for (int i = 0; i < choices.length(); i++) {
            String choice = String.valueOf(choices.charAt(i));
            printKPCWithOutMemory(remainingQues, ans + choice);
        }
    }

}
