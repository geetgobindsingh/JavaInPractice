package leetcode.hard;

import java.util.*;

public class NumberOfMusicPlaylist {
    public static void main(String[] args) {
//        System.out.print(numMusicPlaylists(3,3,1));
//        System.out.print("\n");
//        System.out.print(numMusicPlaylists(2,3,0));
//        System.out.print("\n");
//        System.out.print(numMusicPlaylists(2,3,1));
//        System.out.print("\n");
        System.out.print(numMusicPlaylists(3, 4, 1));
        System.out.print("\n");
    }

    //brute force
    public static int numMusicPlaylists(int n, int goal, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> playLists = new ArrayList<>();
        generatePlayList(0, n, goal, new ArrayList<Integer>(), playLists);
        for (List<Integer> list : playLists) {
            if (k == 0 || isValidPlayList(list, goal, k)) {
                result.add(list);
            }
        }
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
        return result.size();
    }

    private static boolean isValidPlayList(List<Integer> list, int goal, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < goal; i++) {
            if (map.containsKey(list.get(i))) {
                int lastIndex = map.get(list.get(i)) + 1;
                Set<Integer> set = new HashSet<>();
                for (int j = lastIndex; j < i; j++) {
                    set.add(list.get(j));
                }
                if (set.size() != k) {
                    return false;
                }
            }
            map.put(list.get(i), i);
        }
        return true;
    }


    private static void generatePlayList(int i, int n, int goal, ArrayList<Integer> asf, List<List<Integer>> playLists) {
        if (i == goal) {
            if (new HashSet<>(asf).size() == n) {
                playLists.add(new ArrayList<>(asf));
            }
            return;
        }
        for (int j = 1; j <= n; j++) {
            asf.add(j);
            generatePlayList(i + 1, n, goal, asf, playLists);
            asf.remove(asf.size() - 1);
        }

    }
}
