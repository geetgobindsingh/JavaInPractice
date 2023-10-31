package gfg.amazonprep.arrays;


import java.util.ArrayList;

public class MountainSubarrayProblem {

    public static void main(String[] args) {
//        int[] a = new int[]{2, 3, 2, 4, 4, 6, 3, 2};
        int[] a = new int[]{14126, 31676, 1420, 5296, 10659, 15370, 26862, 2698, 26982};
        ArrayList<Pair> queries = new ArrayList<>();
        queries.add(new Pair(2, 8));
        queries.add(new Pair(0, 7));
//        queries.add(new Pair(1, 3));
        for (Boolean val : processQueries(a, a.length, queries, queries.size())) {
            System.out.print(val + " ");
        }
    }

    static class Pair {
        public final int key;
        public final int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = key;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

    }

    public static ArrayList<Boolean> processQueries(int[] a, int n, ArrayList<Pair> queries,
                                                    int q) {
        ArrayList<Boolean> result = new ArrayList<>();
        int i = 0;
        while (i < q) {
            int startIndex = (int) queries.get(i).getKey();
            int endIndex = (int) queries.get(i).getValue();
            boolean inc = false;
            boolean dec = false;
            boolean terminate = false;
            while (startIndex >= 0 && startIndex < endIndex && startIndex < n) {
                if (a[startIndex] <= a[startIndex + 1] && (startIndex + 1) <= endIndex) {
                    if (dec) {
                        terminate = true;
                        break;
                    }
                    if (!inc) {
                        inc = true;
                    }
                } else if (a[startIndex] >= a[startIndex + 1] && (startIndex + 1) <= endIndex) {
                    if (!dec) {
                        dec = true;
                    }
                }
                startIndex++;
            }

            result.add(!terminate);
            i++;
        }
        return result;
    }
}
