package daa.sorting;

//TODO: @Difficult
public class InsertionSortLinkedList {
    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        head.next = new Node(1);
        head.next.next = new Node(-1);
        head.next.next.next = new Node(3);
        displayList(head);
        head = insertionSort(head);
        displayList(head);
    }

    private static void displayList(Node head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.data + " -> ");
            } else {
                System.out.print(head.data);
            }
            head = head.next;
        }
        System.out.print("\n");
    }

    private static Node insertionSort(Node head) {
        /*
        1
        1 0
        0 1
        0 1 -1
        -1 0 1
        -1 0 1 2
        -1 0 1 2
         */
        if (head == null) return head;
        Node current = head.next;
        Node prev = head;
        while (current != null) {
            if (current.data < prev.data) {
                Node temp = head;
                while (temp.data <= current.data) {
                    temp = temp.next;
                }
                if (temp.data != current.data) {
                    head = swapNodes(head, prev, current, temp);
                }
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    private static Node swapNodes(Node head, Node prev, Node current, Node temp) {
        //delete node
        prev.next = current.next;
        current.next = null;

        //insert
        return sortedInsert(head, temp, current);
    }

    private static Node sortedInsert(Node head, Node pointer, Node node) {
        if (head == pointer) {
            node.next = head;
            return node;
        } else {
            Node current = head;
            while (current.next != pointer) {
                current = current.next;
            }
            current.next = node;
            node.next = pointer;
            return head;
        }
    }

    //FAST
    public Node insertionSortList2(Node head) {
        Node dummy = new Node(Integer.MIN_VALUE);
        Node cur = dummy;
        while (head != null) {
            if (head.data < cur.data) {
                cur = dummy;
            }
            Node next = head.next;
            while (cur.next != null && cur.next.data < head.data) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return dummy.next;
    }

    // FASTEST
    public Node insertionSortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;

        Node l1 = insertionSortList(head);
        Node l2 = insertionSortList(slow);
        return merge(l1, l2);
    }

    public Node merge(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node head = null, tail = null;
        while (l1 != null && l2 != null) {
            if (l1.data > l2.data) {
                Node temp = l1;
                l1 = l2;
                l2 = temp;
            }
            Node toInsert = l1;
            l1 = l1.next;
            toInsert.next = null;
            if (head == null) {
                head = tail = toInsert;
            } else {
                tail = tail.next = toInsert;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }

        return head;
    }
}
