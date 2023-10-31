package leetcode.hard;

import java.util.*;

public class CountVowelsPermutation {
    public static void main(String[] args) {
        CountVowelsPermutation obj = new CountVowelsPermutation();
        System.out.println(obj.countVowelPermutation(1));
        System.out.println(obj.countVowelPermutation(2));
        System.out.println(obj.countVowelPermutation(5));
        System.out.println(obj.countVowelPermutation(144));
    }

    public int countVowelPermutation(int n) { //fastest
        if (n == 1) {
            return 5;
        }
        long mod = 1_000_000_007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0;
        for (int j = 1; j < n; j++) {
            a1 = (e + i + u) % mod;
            e1 = (a + i) % mod;
            i1 = (e + o) % mod;
            o1 = i;
            u1 = (i + o) % mod;
            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }
        return (int) ((a + e + i + o + u) % mod);
    }
    public int countVowelPermutation3(int n) { // dp
        int mod = 1000_000_007;
        long dp[][] = new long[5][n];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>(Arrays.asList(1, 2, 4)));
        map.put(1, new HashSet<>(Arrays.asList(0, 2)));
        map.put(2, new HashSet<>(Arrays.asList(1, 3)));
        map.put(3, new HashSet<>(Collections.singletonList(2)));
        map.put(4, new HashSet<>(Arrays.asList(2, 3)));

        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < 5; ++i) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    long sum = 0;
                    for (int prev : map.get(i)) {
                        sum = (sum + dp[prev][j - 1]) % mod;
                    }
                    dp[i][j] = sum % mod;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 5; ++i) {
            sum = (sum + dp[i][n - 1]) % mod;
        }
        return (int) sum % mod;
    }

    public int countVowelPermutation2(int n) { // tle once again
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        HashMap<Character, Set<Character>> map = new HashMap<>();
        map.put('a', new HashSet<>(Collections.singletonList('e')));
        map.put('e', new HashSet<>(Arrays.asList('a', 'i')));
        map.put('i', new HashSet<>(Arrays.asList('a', 'e', 'o', 'u')));
        map.put('o', new HashSet<>(Arrays.asList('i', 'u')));
        map.put('u', new HashSet<>(Collections.singletonList('a')));
        int count = 0;
        for (char c : vowels) {
            count = count + countValidPermutations(c, n - 1, map);
        }
        return count;
    }

    private int countValidPermutations(char c,
                                       int n,
                                       HashMap<Character, Set<Character>> map) {
        if (n == 0) return 1;
        int count = 0;
        for (char next : map.get(c)) {
            count = count + (countValidPermutations(next, n - 1, map));
        }
        return count;
    }

    public int countVowelPermutation1(int n) { //tle
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        HashMap<Character, Set<Character>> map = new HashMap<>();
        map.put('a', new HashSet<>(Collections.singletonList('e')));
        map.put('e', new HashSet<>(Arrays.asList('a', 'i')));
        map.put('i', new HashSet<>(Arrays.asList('a', 'e', 'o', 'u')));
        map.put('o', new HashSet<>(Arrays.asList('i', 'u')));
        map.put('u', new HashSet<>(Collections.singletonList('a')));
        return countValidPermutations(n, vowels, map, new StringBuilder(""));
    }

    private int countValidPermutations(int n, char[] vowels,
                                       HashMap<Character, Set<Character>> map,
                                       StringBuilder ssf) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        if (ssf.length() == 0) {
            for (char c : vowels) {
                ssf.append(c);
                count = count + countValidPermutations(n - 1, vowels, map, new StringBuilder(ssf.toString()));
                ssf.setLength(ssf.length() - 1);
            }
        } else {
            char prev = ssf.charAt(ssf.length() - 1);
            for (char next : map.get(prev)) {
                ssf.append(next);
                count = count + countValidPermutations(n - 1, vowels, map, new StringBuilder(ssf.toString()));
                ssf.setLength(ssf.length() - 1);
            }
        }

        return count;
    }

//    private boolean isValid(char first, char second) {
//        if (first == 'a' && second == 'e') {
//            return true;
//        } else if (first == 'e' && (second == 'a' || second == 'i')) {
//            return true;
//        } else if (first == 'i' && (second != 'i')) {
//            return true;
//        } else if (first == 'o' && (second == 'i' || second == 'u')) {
//            return true;
//        } else if (first == 'u' && (second != 'a')) {
//            return true;
//        }
//        return false;
//    }
}
