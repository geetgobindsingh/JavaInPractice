package gfg.amazonprep.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class TopKFrequentElementsInArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        for (Integer i : TopK(list, 2)) {
            System.out.print(i + " ");
        }
    }

    public static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static ArrayList<Integer> TopK(ArrayList<Integer> array, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if (o2.second == o1.second) {
                    return Integer.compare(o2.first, o1.first);
                }
                return Integer.compare(o2.second, o1.second);
            }
        });
        for (Integer key : map.keySet()) {
            pq.add(new pair(key, map.get(key)));
        }
        map.clear();
        while (k > 0) {
            k--;
            if (!pq.isEmpty()) {
                list.add(pq.poll().first);
            }
        }
        return list;
    }
}
