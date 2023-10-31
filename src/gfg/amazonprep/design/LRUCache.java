package gfg.amazonprep.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
    public static void main(String[] args) {
        LRUCach obj = new LRUCachWithQueue(2);
        obj.put(2, 1);
        obj.put(2, 2);
        System.out.print(obj.get(2));
        obj.put(1, 1);
        obj.put(4, 1);
        System.out.print(obj.get(2));

        System.out.print("\n");

        LRUCach obj1 = new LRUCacheWithLinkedList(2);
        obj1.put(2, 1);
        obj1.put(2, 2);
        System.out.print(obj1.get(2));
        obj1.put(1, 1);
        obj1.put(4, 1);
        System.out.print(obj1.get(2));

        System.out.print("\n");

        LRUCach obj2 = new LRUCacheWithDLL(2);
        obj2.put(2, 1);
        obj2.put(2, 2);
        System.out.print(obj2.get(2));
        obj2.put(1, 1);
        obj2.put(4, 1);
        System.out.print(obj2.get(2));
    }

    static interface LRUCach {
        int get(int key);

        void put(int key, int value);
    }

    //SUPER FAST AND FASTEST OF FASTEST
    static class LRUCacheWithDLL implements LRUCach {
        private final static int MAX_CAPACITY = 3001;

        static class Node {
            Node prev;
            Node next;
            int value;
            int key;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }


        private class DoublyLinkedList {
            private Node head;
            private Node tail;

            Node appendAsLast(int key, int value) {
                Node newNode = new Node(key, value);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }

                return newNode;
            }

            void appendAsLast(Node node) {
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
            }

            void remove(Node node) {
                if (node == head && head == tail) {
                    head = null;
                    tail = null;
                } else if (node == head) {
                    head = head.next;
                    head.prev = null;
                    node.next = null;
                } else if (node == tail) {
                    tail = tail.prev;
                    tail.next = null;
                    node.prev = null;
                } else {
                    Node prev = node.prev;
                    Node next = node.next;
                    prev.next = next;
                    next.prev = prev;
                    node.prev = null;
                    node.next = null;
                }
            }

            Node removeFirst() {
                if (head == null) {
                    return null;
                }

                Node deleted = head;
                if (head.next == null) {
                    head = null;
                    tail = null;
                } else {
                    head.next.prev = null;
                    head = head.next;
                    deleted.next = null;
                }

                return deleted;
            }
        }


        private Node[] nodes = new Node[MAX_CAPACITY];
        private DoublyLinkedList queue = new DoublyLinkedList();

        private int size = 0;
        private int capacity;

        public LRUCacheWithDLL(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node ref = nodes[key];
            if (ref == null) {
                return -1;
            }

            queue.remove(ref);
            queue.appendAsLast(ref);

            return ref.value;
        }

        public void put(int key, int value) {
            Node ref = nodes[key];
            if (ref == null) {
                if (size >= capacity) {
                    ref = queue.removeFirst();
                    nodes[ref.key] = null;
                    ref.key = key;
                    ref.value = value;
                    queue.appendAsLast(ref);
                    nodes[key] = ref;
                } else {
                    ref = queue.appendAsLast(key, value);
                    nodes[key] = ref;
                    ++size;
                }
            } else {
                ref.value = value;
                queue.remove(ref);
                queue.appendAsLast(ref);
            }
        }
    }

    static class Node {
        int val;
        int key;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node() {
        }
    }

    //It is fastest
    static class LRUCacheWithLinkedList implements LRUCach {

        public Node head;
        public Node tail;
        public HashMap<Integer, Node> map;
        public int count;
        public int capacity;

        public LRUCacheWithLinkedList(int capacity) {
            count = 0;
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            map = new HashMap();
        }

        public int get(int key) {
            int rs = -1;
            if (map.containsKey(key)) {
                Node val = map.get(key);
                updateNode(val);
                rs = val.val;
            }
//        printNode();
            return rs;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node val = map.get(key);
                val.val = value;
                updateNode(val);
            } else {
                Node val = new Node(key, value);
                map.put(key, val);
                if (count < capacity) {
                    count++;
                    addNode(val);
                } else {
                    map.remove(tail.pre.key);
                    removeNode();
                    addNode(val);
                }
            }
//        printNode();
        }


        public void updateNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public void addNode(Node node) {

            head.next.pre = node;
            node.pre = head;

            node.next = head.next;
            head.next = node;
        }

        public void removeNode() {
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
        }

        public void printNode() {
            Node t = head.next;

            while (t != tail) {
                System.out.print(t.val + "->");
                t = t.next;
            }
            System.out.println();

        }
    }

    // it is slow
    static class LRUCachWithQueue implements LRUCach {
        private final int capacity;
        private final Queue<Integer> queue;
        private final HashMap<Integer, Integer> map;

        public LRUCachWithQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new LinkedList<>();
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                queue.remove(key);
                queue.offer(key);
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (queue.size() == capacity) {
                    map.remove(queue.poll());
                }
                queue.offer(key);
            } else {
                queue.remove(key);
                queue.offer(key);
            }
            map.put(key, value);
        }
    }

}
