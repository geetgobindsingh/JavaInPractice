package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LastVisitedIntegers {
    public static void main(String[] args) {
        LastVisitedIntegers obj = new LastVisitedIntegers();
        displayList(obj.lastVisitedIntegers(Arrays.asList("1","2","prev","prev","prev")));
        displayList(obj.lastVisitedIntegers(Arrays.asList("1","prev","2","prev","prev")));
    }

    private static void displayList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < words.size(); ++i) {
            String w = words.get(i);
            if (w.equalsIgnoreCase("prev")) {
                int j = i;
                int k = temp.size() - 1;
                while (j < words.size() && words.get(j).equalsIgnoreCase("prev")) {
                    if (k >= 0) {
                        result.add(temp.get(k--));
                    } else {
                        result.add(-1);
                    }
                    j++;
                }
                i = j - 1;
            } else {
                temp.add(Integer.parseInt(w));
            }
        }
        return result;
    }

}
