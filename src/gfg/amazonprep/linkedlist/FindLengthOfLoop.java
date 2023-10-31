package gfg.amazonprep.linkedlist;

public class FindLengthOfLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(countNodesinLoop(head));
    }

    public static int countNodesinLoop(Node head) {
        boolean loopExist = false;
        Node slowP = head;
        Node fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                loopExist = true;
                break;
            }
        }

        if (loopExist) {
            int counter = 0;
            while (fastP != null && fastP.next != null) {
                counter++;
                slowP = slowP.next;
                fastP = fastP.next.next;
                if (slowP == fastP) {
                    break;
                }
            }
            return counter;
        } else {
            return -1;
        }
    }

    public static boolean detectLoop(Node head) {
        boolean loopExist = false;
        Node slowP = head;
        Node fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                return true;
            }
        }
        return loopExist;
    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
