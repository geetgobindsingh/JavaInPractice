package pepcoding.recursion;

public class PowerSetWithNoExtraMemory {
    /*
   input: abc
   output:
   [, c, b, bc, a, ac, ab, abc]

    */
    // V.Important
    public static void main(String[] args) {
        String input = "abc";
        printAllSubSequences(input, "");
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
