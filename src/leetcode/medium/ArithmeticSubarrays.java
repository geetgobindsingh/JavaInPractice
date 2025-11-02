package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticSubarrays {
    public static void main(String[] args) {
        ArithmeticSubarrays obj = new ArithmeticSubarrays();
        for (Boolean b : obj.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5})) {
            System.out.print(b + " ");
        }
        System.out.print("\n");
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        return result;
    }
}
