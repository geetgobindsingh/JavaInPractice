package leetcode.easy;

import java.lang.reflect.Array;
import java.util.*;

public class AssignCookies {
    public static void main(String[] args) {
        AssignCookies obj = new AssignCookies();
        System.out.println(obj.findContentChildren(new int[]{1, 2, 3}, new int[]{}));
        System.out.println(obj.findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
        System.out.println(obj.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(obj.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(obj.findContentChildren(new int[]{7,8,9,10}, new int[]{5,6,7,8}));
    }

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0;
        int j = 0;
        while (true) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
            if (i == g.length || j == s.length) {
                break;
            }
        }
        return count;
    }
}
