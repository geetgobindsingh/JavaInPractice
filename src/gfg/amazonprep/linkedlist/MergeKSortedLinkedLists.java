package gfg.amazonprep.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

//TODO: @Interesting
public class MergeKSortedLinkedLists extends BaseLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node a1 = new Node(2);
        Node b1 = new Node(3);
        head1.next = a1;
        a1.next = b1;

        Node head2 = new Node(4);
        Node a2 = new Node(5);
        head2.next = a2;

        Node head3 = new Node(5);
        Node a3 = new Node(6);
        head3.next = a3;

        Node head4 = new Node(7);
        Node a4 = new Node(8);
        head4.next = a4;

        Node[] ar = new Node[]{head1, head2, head3, head4};

        printList(mergeKList(ar, ar.length));
    }

    static class Pair {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static Node mergeKList(Node[] a, int N) {
        Node result = null;
        Node current = null;
        Node[] ar = new Node[N];
        PriorityQueue<Pair> PQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.key, o2.key);
            }
        });
        int index = 0;
        for (Node n : a) {
            PQ.add(new Pair(n.data, index));
            ar[index++] = n;
        }

        while (!PQ.isEmpty()) {
            for (Pair pair : PQ) {
                if (result == null) {
                    Node target = ar[pair.value];
                    ar[pair.value] = ar[pair.value].next;
                    PQ.remove(pair);
                    if (ar[pair.value] != null) {
                        PQ.add(new Pair(ar[pair.value].data, pair.value));
                    }
                    target.next = null;
                    result = target;
                    current = target;
                } else {
                    Node target = ar[pair.value];
                    ar[pair.value] = ar[pair.value].next;
                    PQ.remove(pair);
                    if (ar[pair.value] != null) {
                        PQ.add(new Pair(ar[pair.value].data, pair.value));
                    }
                    target.next = null;
                    current.next = target;
                    current = current.next;
                }
                break;
            }

        }

        return result;
    }
}
