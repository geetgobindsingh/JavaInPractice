package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfHomogenousSubstrings {
    public static void main(String[] args) {
        CountNumberOfHomogenousSubstrings obj = new CountNumberOfHomogenousSubstrings();
        System.out.println(obj.countHomogenous("abbcccaa"));
        System.out.println(obj.countHomogenous("zzzzz"));
        System.out.println(obj.countHomogenous("xy"));
    }

    public int countHomogenous(String s) {
        int MOD = (int) 1e9 + 7;
        int n = s.length();
        long ans = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            int cnt = j - i;
            ans += (long) (1 + cnt) * cnt / 2;
            ans %= MOD;
        }
        return (int) ans;
    }
    public int countHomogenous1(String s) { // tle
        HashMap<String, Integer> map = new HashMap<>();
        String cur = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur == null) {
                cur = String.valueOf(c);
                map.put(cur, 1);
            } else {
                if (cur.charAt(cur.length() - 1) == c) {
                    for (int j = cur.length(); j >= 1; j--) {
                        String sub = cur.substring(0, j);
                        map.put(sub, map.get(sub) + 1);
                    }
                    cur = cur + c;
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                } else {
                    cur = String.valueOf(c);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }

        long sum = 0;
        int mod = 1000_000_007;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sum = (sum + entry.getValue()) % mod;
        }
        return (int) sum % mod;
    }
}
