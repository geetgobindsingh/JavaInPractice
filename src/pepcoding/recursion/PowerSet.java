package pepcoding.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /*
    input: abc
    output:
    [, c, b, bc, a, ac, ab, abc]

     */
    // Important
    public static void main(String[] args) {
        String input = "abc";
        List<String> subSequences = getSubSequence(input);
        System.out.print(subSequences);
        printAllSubSequences(input, "");
    }

    private static ArrayList<String> getSubSequence(String input) { // T = O(N) && S = O(1)
        if (input.isEmpty()) {
            ArrayList<String> list = new ArrayList<String>();
            list.add("");
            return list;
        }
        char ch = input.charAt(0);
        String subString = input.substring(1);

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> subSequences = getSubSequence(subString);
        for (String subSequence : subSequences) {
            result.add("" + subSequence);
        }
        for (String subSequence : subSequences) {
            result.add(ch + subSequence);
        }
        return result;
    }

    private static void printAllSubSequences(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String remainingQues = ques.substring(1);
        printAllSubSequences(remainingQues, ans + ch);
        printAllSubSequences(remainingQues, ans + "");
    }
}
