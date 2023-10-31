package leetcode.easy;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        BackspaceStringCompare obj = new BackspaceStringCompare();
        System.out.println(obj.backspaceCompare("ab#c", "ad#c"));
        System.out.println(obj.backspaceCompare("xywrrmp", "xywrrm#p"));
    }

    public boolean backspaceCompare(String s, String t) { //fastest
        int i = s.length() - 1, j = t.length() - 1;
        int skip1 = 0, skip2 = 0;
        for (; i >= 0 || j >= 0; --i, --j) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    ++skip1;
                    --i;
                } else if (skip1 > 0) {
                    --skip1;
                    --i;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    ++skip2;
                    --j;
                } else if (skip2 > 0) {
                    --skip2;
                    --j;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
        }
        return true;
    }
    public boolean backspaceCompare1(String s, String t) {

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '#') {
                sb1.setLength(sb1.length() - 1);
            } else {
                sb1.append(ch);
            }
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            if (ch == '#') {
                if (st.size() > 0) {
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (!st.isEmpty()) {
            sb2.append(st.pop());
        }
        sb2 = sb2.reverse();
        if (sb1.length() != sb2.length()) return false;
        for (int i = 0; i < sb1.length(); ++i) {
            if (sb1.charAt(i) != sb2.charAt(i)) return false;
        }
        return true;
    }

}
