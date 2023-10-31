package leetcode.medium;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class RandomPointer {
    public static void main(String[] args) {
        RandomPointer obj = new RandomPointer();
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node7.random = null;
        node13.next = node11;
        node13.random = node7;
        node11.next = node10;
        node11.random = node1;
        node10.next = node10;
        node10.random = node11;
        node1.next = null;
        node1.random = node7;
        obj.copyRandomList(node7);
    }

    public Node copyRandomList(Node head) { // Space: O(1) Time: O(n)
            Node iter = head;
            Node front = head;

            // First round: make copy of each node,
            // and link them together side-by-side in a single list.
            while (iter != null) {
                front = iter.next;

                Node copy = new Node(iter.val);
                iter.next = copy;
                copy.next = front;

                iter = front;
            }

            // Second round: assign random pointers for the copy nodes.
            iter = head;
            while (iter != null) {
                if (iter.random != null) {
                    iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
            }

            // Third round: restore the original list, and extract the copy list.
            iter = head;
            Node pseudoHead = new Node(0);
            Node copy = pseudoHead;

            while (iter != null) {
                front = iter.next.next;

                // extract the copy
                copy.next = iter.next;
                copy = copy.next;

                // restore the original list
                iter.next = front;

                iter = front;
            }

            return pseudoHead.next;
    }
    public Node copyRandomList3(Node head) { // Space: O(1) Time: O(n)
        Node curr = head;
        while (curr != null) {
            Node temp = new Node(curr.val);
            if (curr.next != null) {
                temp.next = curr.next;
                curr.next = temp;
            } else {
                curr.next = temp;
            }
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node temp = new Node(0);
        Node copy = temp;
        while (curr != null) {
            copy.next = curr.next;
            copy = copy.next;

            curr.next = curr.next.next;

            curr = curr.next;
        }
        return temp.next;
    }
    public Node copyRandomList2(Node head) { // Space: O(n) Time: O(n)
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node temp = map.get(curr);
            Node next = null;
            Node random = null;
            if (curr.next != null) {
                next = map.get(curr.next);
            }
            if (curr.random != null) {
                random = map.get(curr.random);
            }
            temp.next = next;
            temp.random = random;
            curr = curr.next;
        }

        return map.get(head);
    }
}
