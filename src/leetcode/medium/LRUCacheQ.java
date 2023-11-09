package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRUCacheQ {

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    static class LRUCache {
        private Map<Integer, Node> cache = new HashMap<>();
        private Node head = new Node();
        private Node tail = new Node();
        private int capacity;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                Node node = new Node(key, value);
                cache.put(key, node);
                addToHead(node);
                ++size;
                if (size > capacity) {
                    node = removeTail();
                    cache.remove(node.key);
                    --size;
                }
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }

        private Node removeTail() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }
    static class LRUCache2 {

        final HashMap<Integer, Integer> map;
        final ArrayList<Integer> list;
        final int capacity;

        public LRUCache2(int capacity) {
            map = new HashMap<>();
            list = new ArrayList<Integer>();
            this.capacity = capacity;
        }

        public int get(int key) {
            int val = map.getOrDefault(key, -1);
            if (val == -1) {
                return val;
            } else {
                list.removeIf(integer -> integer == key);
                list.add(0, key);
                return val;
            }
        }

        public void put(int key, int value) {
            boolean exists = list.contains(key);
            map.put(key, value);
            if (!exists) {
                list.add(0, key);
            } else {
                list.removeIf(integer -> integer == key);
                list.add(0, key);
            }

            if (list.size() > capacity) {
                int lastIndex = list.size() - 1;
                int lastKey = list.get(lastIndex);
                list.remove(lastIndex);
                map.remove(lastKey);
            }
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


}
