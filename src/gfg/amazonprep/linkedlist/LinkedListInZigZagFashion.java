package gfg.amazonprep.linkedlist;

public class LinkedListInZigZagFashion extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printList(zigZag(node));
    }

    public static Node zigZag(Node head){
        Node current = head;
        boolean flag = true;
        while (current != null && current.next != null) {
            if (flag) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            } else {
                if (current.data < current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
            current = current.next;
            flag = !flag;
        }
        return head;
    }
}
