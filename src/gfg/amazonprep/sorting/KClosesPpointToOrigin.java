package gfg.amazonprep.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosesPpointToOrigin {
    public static void main(String[] args) {

    }

    public static class tuple {
        int first;
        int second;

        tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static ArrayList<ArrayList<Integer>> kClosest(ArrayList<ArrayList<Integer>> points, int K) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        PriorityQueue<tuple> PQ = new PriorityQueue<>(new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
                int x1 = o1.first * o1.first;
                int y1 = o1.second * o1.second;
                int x2 = o2.first * o2.first;
                int y2 = o2.second * o2.second;
                return (x1 + y1) - (x2 + y2);
            }
        });
        for (ArrayList<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            PQ.add(new tuple(x, y));
        }
        while (K > 0) {
            K--;
            while (!PQ.isEmpty()) {
                tuple t = PQ.poll();
                ArrayList<Integer> l = new ArrayList<>();
                l.add(t.first);
                l.add(t.second);
                list.add(l);
            }
        }
        return list;
    }
}
