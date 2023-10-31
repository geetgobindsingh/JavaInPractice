package gfg.amazonprep.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCacheImpl {
    public static void main(String[] args) throws IOException {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.set(1, 2);
//        lruCache.set(2, 3);
//        lruCache.set(1, 5);
//        lruCache.set(4, 5);
//        lruCache.set(6, 7);
//        System.out.println(lruCache.get(4));
//        System.out.println(lruCache.get(1));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        while (t-- > 0) {
            int capacity = 4;//Integer.parseInt(br.readLine());
            int queries = 87;//Integer.parseInt(br.readLine());
            LRUCache cache = new LRUCache(capacity);
            String[] str = "SET 94 16 SET 93 87 SET 63 22 SET 60 91 SET 41 27 GET 73 GET 12 GET 68 SET 31 83 GET 24 SET 30 36 GET 23 GET 70 SET 57 94 SET 30 43 SET 20 22 GET 38 GET 25 SET 14 71 GET 92 GET 57 SET 71 63 GET 82 SET 85 26 SET 6 37 GET 30 SET 25 58 SET 46 83 GET 68 GET 65 SET 88 51 GET 77 GET 89 GET 4 SET 100 55 GET 61 GET 69 SET 27 13 GET 95 SET 71 96 GET 79 SET 98 2 GET 18 GET 53 GET 2 GET 87 SET 90 66 GET 20 GET 30 SET 98 18 SET 76 82 SET 68 28 GET 98 SET 66 87 GET 84 SET 29 25 SET 30 33 SET 71 20 GET 9 SET 50 41 GET 24 GET 46 GET 52 SET 80 56 GET 65 GET 42 GET 94 GET 35 GET 25 GET 88 GET 44 SET 66 28 SET 33 37 SET 29 38 SET 75 8 SET 96 59 SET 36 38 SET 29 19 SET 29 12 SET 5 77 SET 14 64 GET 7 GET 5 GET 29 GET 70 SET 97 18 GET 44".trim().split(" ");
            int length = str.length;
            int itr = 0;
            for (int i = 0; i < queries && itr < length; i++) {
                String queryType = str[itr++];
                if (queryType.equalsIgnoreCase("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                } else if (queryType.equalsIgnoreCase("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.println(cache.get(key));
                }
            }
//        }
    }

    static class LRUCache {

        public static HashMap<Integer, Integer> cache;
        public static int capacity;
        public static Queue<Integer> queue;

        public LRUCache(int cap) {
            cache = new HashMap<>();
            capacity = cap;
            queue = new LinkedList<>();
        }

        // This method works in O(1)
        public static  int get(int key) {
            if (!cache.isEmpty() && cache.keySet().contains(key)) {
                queue.remove(key);
                queue.add(key);
                return cache.get(key);
            }
            return -1;
        }

        // This method works in O(1)
        public static  void set(int key, int value) {
            if (!cache.isEmpty() && cache.keySet().contains(key)) {
                queue.remove(key);
                queue.add(key);
                cache.put(key, value);
            } else {
                if (cache.size() == capacity) {
                    cache.remove(queue.remove());
                }
                queue.add(key);
                cache.put(key, value);
            }
        }
    }
}
