package leetcode.medium;

import java.util.HashMap;

public class FindTheWinnerOfAnArrayGame {
    public static void main(String[] args) {
        FindTheWinnerOfAnArrayGame obj = new FindTheWinnerOfAnArrayGame();
        System.out.println(obj.getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(obj.getWinner(new int[]{3, 2, 1}, 10));
        System.out.println(obj.getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
        System.out.println(obj.getWinner(new int[]{1, 25, 35, 42, 68, 70}, 1));
        System.out.println(obj.getWinner(new int[]{28,779,346,302,257,535,906,981,313,163,384,395,891,881,332,656,652,84,22,718,953,117,912}, 5));
    }

    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = Math.max(arr[0], arr[1]);
        if (k == 1) {
            return max;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(max, map.getOrDefault(max, 0) + 1);
        for (int i = 2; i < n; i++) {
            max = Math.max(max, arr[i]);
            map.put(max, map.getOrDefault(max, 0) + 1);
            if (map.get(max) >= k) {
                return max;
            }
        }
        return max;
    }
}
