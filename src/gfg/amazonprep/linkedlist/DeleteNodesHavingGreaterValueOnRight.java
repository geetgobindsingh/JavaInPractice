package gfg.amazonprep.linkedlist;

public class DeleteNodesHavingGreaterValueOnRight extends BaseLinkedList {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(25);
        Node aa = new Node(20);
        Node bb = new Node(21);
        Node cc = new Node(25);
        Node ccc = new Node(26);
        Node dd = new Node(25);
        a.next = b;
        b.next = aa;
        aa.next = bb;
        bb.next = cc;
        cc.next = ccc;
        ccc.next = dd;
        printList(compute1(a));
    }


//    public static Node compute(Node head) {
//
//    }

    public static Node compute1(Node head) {
        Node cur = head;
        Node prev = null;
        while (cur != null && cur.next != null) {
            while (cur != null && cur.next != null && cur.data < cur.next.data) {
                if (prev == null) {
                    head = cur.next;
                    cur = head;
                    continue;
                } else {
                    prev.next = cur.next;
                }
                cur = cur.next;
            }
            if (prev != null && prev.data < cur.data) {
                Node stale = head;
                Node prevvv = null;
                while (stale != null) {
                    if (stale.data >= cur.data) {
                        prevvv = stale;
                        stale = stale.next;
                    } else {
                        if (prevvv == null) {
                            head = cur;
                            prevvv = cur;
                        } else {
                            prevvv.next = cur;
                        }
                        break;
                    }
                }
            }

            prev = cur;
            cur = cur.next;
        }

        return head;
    }
}
