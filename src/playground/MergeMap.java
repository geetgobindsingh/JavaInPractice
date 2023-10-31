package playground;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class MergeMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.merge(1, 10, Integer::sum);
        System.out.println(map);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "a");
        treeMap.put(2, "b");
        treeMap.put(3, "c");
        treeMap.merge(1, "A", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        });
        System.out.println(treeMap);
    }
}
