package leetcode.medium;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        KthSymbolInGrammar obj = new KthSymbolInGrammar();
        System.out.println(obj.kthGrammar(3, 3));
        System.out.println(obj.kthGrammar(4, 5));
        System.out.println(obj.kthGrammar(30, 434991989));
    }

    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
    public int kthGrammar1(int n, int k) { // tle
        if (k == 1) {
            return 0;
        }
        if (k == 2) {
            return 1;
        }
        String res = kthGrammar(n - 2, new StringBuilder("01"));
        System.out.println(res);
        return res.charAt(k - 1) - 48;
    }

    public String kthGrammar(int n, StringBuilder s) {
        if (n == 0) {
            return s.toString();
        }
        return kthGrammar(n - 1, s) + kthGrammar(n - 1, getInvertedString(s));
    }

    private StringBuilder getInvertedString(StringBuilder s) {
        int l = s.length();
        StringBuilder res = new StringBuilder();
        res.append(s.substring(l / 2, l));
        res.append(s.substring(0, l / 2));
        return res;
    }
}
