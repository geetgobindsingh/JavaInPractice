package gfg.amazonprep.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromAnUnsortedLinkedList extends BaseLinkedList {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(0);
        Node aa = new Node(2);
        Node bb = new Node(1);
        Node cc = new Node(0);
        a.next = b;
        b.next = aa;
        aa.next = bb;
        bb.next = cc;
        printList(removeDuplicates(a));
    }

    public static Node removeDuplicates(Node head) {
        Node cur = head;
        Set<Integer> set = new HashSet<>();
        Node prev = null;
        while (cur != null) {
            if (set.contains(cur.data)) {
                prev.next = cur.next;
            } else {
                set.add(cur.data);
                prev = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
