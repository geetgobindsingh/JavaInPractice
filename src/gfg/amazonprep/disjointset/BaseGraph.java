package gfg.amazonprep.disjointset;

import java.util.ArrayList;
import java.util.List;

public class BaseGraph {

    public static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static class Graph {
        public int v;
        public List<Pair<Integer, Integer>> edgeList;

        public Graph() {
            v = 0;
            edgeList = new ArrayList<>();
        }
    }
}
