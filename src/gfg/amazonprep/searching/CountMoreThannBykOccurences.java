package gfg.amazonprep.searching;

import java.util.HashMap;

public class CountMoreThannBykOccurences {
    public static void main(String[] args) {
//        String[] sr = "0 -10 1 3 -20".split(" ");
//        String[] sr = "5 4 3 2 1".split(" ");
//        String[] sr = "47 1 4 49 -18 10 26 18 -11 -38 -24 36 44 -11 45 20 -16 28 17 -49 47 -48 -33 42 2 6 -49 30 36 -9 15 39 -6 -31 -10 -21 -19 -33 47 21 31 25 -41 -23 17 6 47 3 36 15 -44 33 -31 -26 -22 21 -18 -21 -47 -31 20 18 -42 -35 -10 -1 46 -27 -32 -5 -4 1 -29 5 29 38 14 -22 -9 0 43 -50 -16 14 -26"
//                .split(" ");
        int[] ar = new int[]{3, 1, 2, 2, 1, 2, 3, 3};
//        int index = 0;
//        for (String s : sr) {
//            ar[index++] = Integer.parseInt(s);
//        }
        System.out.print(countOccurence(ar, ar.length, 4));
    }

    public static int countOccurence(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minCount = n / k;
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > minCount) {
                count++;
            }
        }
        return count;
    }
}
