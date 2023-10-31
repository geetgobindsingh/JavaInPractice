package gfg.amazonprep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PossibleWordsFromPhoneDigits {
    public static void main(String[] args) {
        for (String val : possibleWords(new int[]{2, 3, 4}, 3)) {
            System.out.print(val + " ");
        }
    }

    public static ArrayList<String> possibleWords(int a[], int N) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<String>(Arrays.asList("a", "b", "c")));
        map.put(3, new ArrayList<String>(Arrays.asList("d", "e", "f")));
        map.put(4, new ArrayList<String>(Arrays.asList("g", "h", "i")));
        map.put(5, new ArrayList<String>(Arrays.asList("j", "k", "l")));
        map.put(6, new ArrayList<String>(Arrays.asList("m", "n", "o")));
        map.put(7, new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        map.put(8, new ArrayList<String>(Arrays.asList("t", "u", "v")));
        map.put(9, new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));

        ArrayList<String> result = new ArrayList<>();
        getResults(0, a, "", result, map);
        return result;
    }

    private static void getResults(int index, int[] a,
                                   String sum, ArrayList<String> result,
                                   HashMap<Integer, List<String>> map) {
        if (index == a.length) {
            result.add(sum);
            return;
        }
        for (String val : map.get(a[index])) {
            getResults(index + 1, a, sum + val, result, map);
        }
    }
}
