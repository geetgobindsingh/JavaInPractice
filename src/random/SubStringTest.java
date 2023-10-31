package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubStringTest {
    public static void main(String[] args) {
        String amar = "amar";
        String result = "amar_123";
        System.out.println(result.substring(amar.length() + 1));

        List<List<Integer>> arr = new ArrayList();
        int[] a = new int[]{1,2,4};
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        arr.add(list);
    }
}
