package DSAKiller.strings;

public class ReverseString {
    public static void main(String[] args) {
        char[] ar = new char[]{'a', 'b', 'c'};
        reverseString(ar);
        System.out.println(ar);
        ar = new char[]{'a', 'b', 'c', 'd'};
        reverseString(ar);
        System.out.println(ar);
    }

    // Good
    public static void reverseString(char[] s) {
        int length = s.length;
        int pivot = length / 2;
        for (int i = 0; i < pivot; i++) {
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }

    /// BEST
    public void reverseString1(char[] s) {
        if (s.length == 1)
            return;
        int start = 0, end = s.length - 1;

        while (start < end) {
            char p = s[start];
            s[start] = s[end];
            s[end] = p;
            start++;
            end--;
        }

    }
}
