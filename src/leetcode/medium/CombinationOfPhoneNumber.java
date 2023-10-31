package leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
    Letter Combinations of a Phone Number

    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    2-> abc
    3-> def
    4-> ghi
    5-> jkl
    6-> mno
    7-> pqrs
    8-> tuv
    9-> wxyz

 */
public class CombinationOfPhoneNumber {
    public static void main(String[] args) throws IOException {

        CombinationOfPhoneNumber obj = new CombinationOfPhoneNumber();

        HashMap<Integer, String[]> keyCharactersMap = obj.getCharacterMap();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();


    }

    private HashMap<Integer, String[]> getCharacterMap() {
        HashMap<Integer, String[]> keyCharactersMap = new HashMap<>();
        keyCharactersMap.put(2, new String[]{"a", "b", "c" });
        keyCharactersMap.put(3, new String[]{"d", "e", "f" });
        keyCharactersMap.put(4, new String[]{"g", "h", "i" });
        keyCharactersMap.put(5, new String[]{"j", "k", "l" });
        keyCharactersMap.put(6, new String[]{"m", "n", "o" });
        keyCharactersMap.put(7, new String[]{"p", "q", "r" , "s" });
        keyCharactersMap.put(8, new String[]{"t", "u", "v" });
        keyCharactersMap.put(9, new String[]{"w", "x", "y", "z" });
        return keyCharactersMap;
    }
}
