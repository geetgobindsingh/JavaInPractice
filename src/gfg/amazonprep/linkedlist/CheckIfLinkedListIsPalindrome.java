package gfg.amazonprep.linkedlist;

public class CheckIfLinkedListIsPalindrome extends BaseLinkedList {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(0);
        Node aa = new Node(0);
        Node bb = new Node(1);
//        Node cc = new Node(1);
        a.next = b;
        b.next = aa;
        aa.next = bb;
//        bb.next = cc;
        System.out.print(isPalindrome(a));
    }

    public static boolean isPalindrome(Node head) {
        boolean result = true;
        Node middle = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            middle = middle.next;
        }

        if (fast != null) {
            middle = middle.next;
        }


        while (middle != null && middle.next != null) {
            int temp = middle.data;
            middle.data = middle.next.data;
            middle.next.data = temp;
            middle = middle.next;
        }

        middle = head;
        fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            middle = middle.next;
        }

        if (fast != null) {
            middle = middle.next;
        }

        fast = head;

        while (middle != null && fast != null) {
            if (fast.data == middle.data) {
                fast = fast.next;
                middle = middle.next;
            } else {
                return false;
            }
        }

        return result;
    }
}
