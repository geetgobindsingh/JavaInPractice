package gfg.amazonprep.linkedlist;

//TODO: @Interesting
public class RemoveLoopInLinkedList extends BaseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = a;

        removeLoop(head);
        printList(head);
    }

    public static void removeLoop(Node head) {// O(n) less than 4 sec with smart hack
        Node slowP = head;
        Node fastP = head;

        boolean loopExist = false;
        int count = 1;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                if (loopExist) {
                    break;
                } else {
                    loopExist = true;
                }
            } else if (loopExist) {
                count++;
            }
        }

        if (!loopExist) {
            return;
        }

        /*
        Let s be the size of the loop.
        Now we need 2 pointers again. The first pointer points at the head.
        Second pointer should be s nodes ahead.
        Moves both pointers ahead step by step at same rate.
         This time the meeting point will be the junction node.
         */
        slowP = head;
        fastP = head;
        for (int i = 0; i < count; i++) {
            fastP = fastP.next;
        }
        while (true) {
            if (slowP == fastP) {
                break;
            } else {
                slowP = slowP.next;
                fastP = fastP.next;
            }
        }

        for (int i = 0; i < (count - 1); i++) {
            slowP = slowP.next;
        }
        slowP.next = null;
    }

    public static void removeLoop2(Node head) { //O(n) still tle 4 sec
        Node slowP = head;
        Node fastP = head;

        boolean loopExist = false;
        int count = 1;
        while (slowP != null && fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                if (loopExist) {
                    break;
                } else {
                    loopExist = true;
                }
            } else if (loopExist) {
                count++;
            }
        }

        if (!loopExist) {
            return;
        }

        Node prev = null;
        Node cur = head;

        while (true) {
            if (isLoopParticipant(cur, slowP)) {
                break;
            } else {
                prev = cur;
                for (int i = 0; i < (count - 1); i++) {
                    cur = cur.next;
                }
            }
        }

        if (prev != null) {
            while (true) {
                if (isLoopParticipant(prev, slowP)) {
                    break;
                } else {
                    prev = prev.next;
                }
            }
        } else {
            prev = head;
        }
        for (int i = 0; i < (count - 1); i++) {
            prev = prev.next;
        }
        prev.next = null;

    }


    public static void removeLoop1(Node head) { //O(n^2) tle 4 sec
        Node slowP = head;
        Node fastP = head;

        boolean loopExist = false;
        int count = 0;
        while (slowP != null && fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                if (loopExist) {
                    break;
                } else {
                    loopExist = true;
                }
            } else if (loopExist) {
                count++;
            }
        }

        if (!loopExist) {
            return;
        }

        Node cur = head;
        while (loopExist) {
            if (isLoopParticipant(cur, slowP)) {
                break;
            } else {
                cur = cur.next;
            }
        }

        for (int i = 0; i < count; i++) {
            cur = cur.next;
        }
        cur.next = null;
    }

    public static boolean isLoopParticipant(Node candidate, Node looper) {
        Node loop = looper.next;
        while (loop != looper) {
            if (candidate == loop) {
                return true;
            }
            loop = loop.next;
        }
        return false;
    }
}
