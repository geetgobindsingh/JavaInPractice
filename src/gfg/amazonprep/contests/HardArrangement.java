package gfg.amazonprep.contests;

import java.util.*;

// TODO: @Difficult
public class HardArrangement {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 3, 2, 2, 6, 1, 1, 4, 7));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 0, 3, 4, 2, 0));
        for (Integer i : arrange3(A, B, A.size())) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (Integer i : arrange2(A, B, A.size())) {
            System.out.print(i + " ");
        }
    }

    static class Pair {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }


    public static ArrayList<Integer> arrange3(ArrayList<Integer> A, ArrayList<Integer> B, int n) {
        PriorityQueue<Pair> PQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.key.equals(o2.key)) {
                    return Integer.compare(o1.value, o2.value);
                }
                return Integer.compare(o2.key, o1.key);
            }
        });
        for (int i = 0; i < n; i++) {
            PQ.add(new Pair(A.get(i), B.get(i)));
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair p = PQ.poll();
            result.add(p.value, p.key);
        }
        return result;
    }


    // This solution is wrong, need to know why it is failing
    public static ArrayList<Integer> arrange2(ArrayList<Integer> A, ArrayList<Integer> B, int n) {
        Integer[] ar = new Integer[n];
        List<Integer> space = new ArrayList<>();
        PriorityQueue<Pair> PQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.key.equals(o2.key)) {
                    return Integer.compare(o2.value, o1.value);
                }
                return Integer.compare(o1.key, o2.key);
            }
        });
        for (int i = 0; i < n; i++) {
            space.add(i);
            PQ.add(new Pair(A.get(i), B.get(i)));
        }
        while (!PQ.isEmpty()) {
            Pair pair = PQ.poll();
            if (ar[pair.value] == null) {
                ar[pair.value] = pair.key;
                space.remove(pair.value);
            } else {
                Integer index = space.get(pair.value);
                ar[index] = pair.key;
                space.remove(index);
            }
        }
        return new ArrayList<Integer>(Arrays.asList(ar));
    }
}
