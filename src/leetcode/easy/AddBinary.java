package leetcode.easy;

public class AddBinary {
    public static void main(String[] args) {
        System.out.print(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder s = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                s.append(getSum(0, 0, carry));
                carry = getCarry(0, 0, carry);
            } else if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                s.append(getSum(1, 1, carry));
                carry = getCarry(1, 1, carry);
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                s.append(getSum(1, 0, carry));
                carry = getCarry(1, 0, carry);
            }
            i--;
            j--;
        }
        while (j >= 0) {
            if (b.charAt(j) == '1') {
                s.append(getSum(1, 0, carry));
                carry = getCarry(1, 0, carry);
            } else {
                s.append(getSum(0, 0, carry));
                carry = getCarry(0, 0, carry);
            }
            j--;
        }
        if (carry != 0) {
            s.append(getSum(0, 0, carry));
            carry = 0;
        }
        return s.reverse().toString();
    }

    public static char getSum(int a, int b, int carry) {
        int sum = a + b + carry;
        if (sum == 0) {
            return '0';
        }
        if (sum == 1) {
            return '1';
        }
        if (sum == 2) {
            return '0';
        }
        if (sum == 3) {
            return '1';
        } else return '0';
    }

    public static int getCarry(int a, int b, int carry) {
        int sum = a + b + carry;
        if (sum == 0) {
            return 0;
        }
        if (sum == 1) {
            return 0;
        }
        if (sum == 2) {
            return 1;
        }
        if (sum == 3) {
            return 1;
        } else return 0;
    }
}
