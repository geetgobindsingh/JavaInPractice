package gfg.amazonprep.linkedlist;

public class SwapKthNodesFromEnds extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
//        Node node3 = new Node(4);


        node.next = node1;
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        printList(swapkthnode(node, 3, 1));
    }

    public static Node swapkthnode(Node head, int num, int K) { // W/o changing content
        int i = 1;
        Node left = head;
        Node prevLeft = null;
        while (i < K) {
            prevLeft = left;
            left = left.next;
            i++;
        }
        i = 1;
        Node right = head;
        Node preRight = null;
        while (i < (num - K + 1)) {
            preRight = right;
            right = right.next;
            i++;
        }

        if (prevLeft == null) {
            Node temp = head;
            head = head.next;
            head.next = temp;
            temp.next = null;
        } else {
            if (left == right) {

            } else if (left.next == right) {
                Node temp = right;
                prevLeft.next = temp;
                left.next = right.next;
                temp.next = left;
            } else {
//                Node temp = right;
//                prevLeft.next = temp;
//                preRight.next = left;
//                left.next = right.next;
//                temp.next = left.next;
            }
        }

        return head;
    }

    public static Node swapkthnode1(Node head, int num, int K) { // W changing content
        int i = 1;
        Node left = head;
        while (i < K) {
            left = left.next;
            i++;
        }
        i = 1;
        Node right = head;
        while (i < (num - K + 1)) {
            right = right.next;
            i++;
        }
        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        return head;
    }
}
