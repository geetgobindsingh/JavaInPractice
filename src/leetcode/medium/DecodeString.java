package leetcode.medium;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        int num = 0;
        String result = "";
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(num);
                resultStack.push(result);
                num = 0;
                result = "";
            } else if (c == ']') {
                StringBuilder t = new StringBuilder();
                for (int i = 0, n = countStack.pop(); i < n; ++i) {
                    t.append(result);
                }
                result = resultStack.pop() + t.toString();
            } else {
                result += String.valueOf(c);
            }
        }
        return result;
    }

    public static String decodeString2(String s) {
        String result = "";
        Stack<Character> st = new Stack<>();
        int deep = 0;
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
            if (st.peek() == ']') {
                deep--;
                if (deep == 0) {
                    String subString = "";
                    while (!st.isEmpty()) {
                        subString = st.pop() + subString;
                    }
                    result = result + decodeSubString(subString);
                }
            } else if (st.peek() == '[') {
                deep++;
            }
        }
        String ans = "";
        while (st.size() > 0) {
            ans = st.pop() + ans;
        }
        return result + ans;
    }

    public static String decodeSubString(String s) {
        String result = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String ans2 = "";
            if (s.charAt(i) == ']') {
                String ans = "";
                while (st.size() > 0 && st.peek() != '[') {
                    ans = st.pop() + ans;
                }
                st.pop();
                int times = 0;
                while (st.size() > 0 && Character.isDigit(st.peek())) {
                    times = 10 * times + (st.pop() - '0');
                }
                for (int j = 1; j <= times; j++) {
                    ans2 = ans2 + ans;
                }
            } else {
                st.push(s.charAt(i));
            }
            result = ans2 + result;
        }
        return result;
    }
}
