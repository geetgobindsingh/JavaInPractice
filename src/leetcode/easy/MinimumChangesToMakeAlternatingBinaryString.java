package leetcode.easy;

public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        MinimumChangesToMakeAlternatingBinaryString obj = new MinimumChangesToMakeAlternatingBinaryString();
        System.out.println(obj.minOperations("0100"));
        System.out.println(obj.minOperations("10"));
        System.out.println(obj.minOperations("1111"));
        System.out.println(obj.minOperations("1101"));
        System.out.println(obj.minOperations("10010100"));
    }


    // 1101 -> 1001
    // 1101 -> 0101

    public int minOperations(String s) {
        char[] ar = s.toCharArray();
        if (s.length() == 1) return 0;
        return Math.min(minOp(ar, 0, '0'), minOp(ar, 0, '1'));
    }

    private int minOp(char[] ar, int i, char last) {
        if (i == ar.length) return 0;
        if (isSame(ar, i, last)) {
            last = updateLast(last);
            return (last == ar[i]) ? 0 : 1 + minOp(ar, i + 1, last);
        }
        last = updateLast(last);
        return minOp(ar, i + 1, last);
    }

    public char updateLast(char last) {
        return last == '0' ? '1' : '0';
    }

    public boolean isSame(char[] ar, int i, char last) {
        return i >= 0 && i < (ar.length) && last == ar[i];
    }
}
