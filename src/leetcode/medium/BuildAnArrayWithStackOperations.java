package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildAnArrayWithStackOperations {
    public static void main(String[] args) {
        BuildAnArrayWithStackOperations obj = new BuildAnArrayWithStackOperations();
        for (String v : obj.buildArray(new int[]{1, 3}, 3)) {
            System.out.print(v + " ");
        }
        System.out.println();
        for (String v : obj.buildArray(new int[]{1, 2, 3}, 3)) {
            System.out.print(v + " ");
        }
        System.out.println();
        for (String v : obj.buildArray(new int[]{1, 2}, 4)) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        int current = 1;
        Stack<Integer> st = new Stack<>();
        List<String> ops = new ArrayList<>();
        while (current <= n) {
            st.push(current);
            ops.add("Push");
            if (target[index] != st.peek()) {
                ops.add("Pop");
            } else {
                index++;
            }
            if (index == target.length) {
                break;
            }
            current++;
        }
        return ops;
    }
}
