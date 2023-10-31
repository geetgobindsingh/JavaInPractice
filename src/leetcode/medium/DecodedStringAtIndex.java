package leetcode.medium;

public class DecodedStringAtIndex {
    public static void main(String[] args) {
        DecodedStringAtIndex obj = new DecodedStringAtIndex();
        System.out.println(obj.decodeAtIndex("leet2code3", 10));
        System.out.println(obj.decodeAtIndex("ha22", 5));
        System.out.println(obj.decodeAtIndex("a2345678999999999999999", 1));
        System.out.println(obj.decodeAtIndex("a2b3c4d5e6f7g8h9", 69280));
        System.out.println(obj.decodeAtIndex("m26559vishxq9b726mrj", 2022213));
        System.out.println(obj.decodeAtIndex("y959q969u3hb22odq595", 222280369));
        System.out.println(obj.decodeAtIndex("l3mtm5weq7ki78c7hck4", 165511));
    }

    public String decodeAtIndex(String s, int k) {
        long size = 0; // Length of decoded `s`

        for (final char c : s.toCharArray())
            if (Character.isDigit(c))
                size *= c - '0';
            else
                ++size;

        for (int i = s.length() - 1; i >= 0; --i) {
            k %= size;
            if (k == 0 && Character.isAlphabetic(s.charAt(i)))
                return s.substring(i, i + 1);
            if (Character.isDigit(s.charAt(i)))
                size /= s.charAt(i) - '0';
            else
                --size;
        }
        return "";
    }
    public String decodeAtIndex2(String s, int k) {
        int maxLength = k;
        int MAX = 3 * (k / 2);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb = sb1;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int count = ch - '0' - 1;
                String current = sb.toString();
                boolean closeLoop = false;
                while (count > 0) {
                    if ((MAX - sb.length()) <= 0) {
                        sb = sb2;
                    }
                    if ((maxLength - sb.length()) <= 0) {
                        break;
                    }
                    if ((maxLength - sb.length()) > 0 && (sb.length() + current.length()) >= maxLength) {
                        sb.append(current.substring(0, maxLength - sb.length()));
                        closeLoop = true;
                        break;
                    }
                    sb.append(current);
                    count--;
                }
                if (closeLoop) {
                    break;
                }
            } else {
                if ((MAX - sb.length()) <= 0) {
                    sb = sb2;
                }
                if ((maxLength - sb.length()) <= 0) {
                    break;
                }
                sb.append(ch);
            }
        }
        if (k > sb1.length()) {
            return sb2.charAt(k - 1 - sb1.length()) + "";
        } else {
            return sb1.charAt(k - 1) + "";
        }
    }
}
