package gfg.amazonprep.linkedlist;

public class LinkedListThatIsSortedAlternatingly extends BaseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(9);
        Node node2 = new Node(2);
        Node node3 = new Node(8);
        Node node4 = new Node(3);
        Node node5 = new Node(7);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        sort(node);
        printList(node);
    }

    public static Node sort(Node head) {
        Node current = head;
        while (current != null && current.next != null) {

            if (current.data > current.next.data) {
                int temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;

                Node inter = head;
                while (inter.data <= current.data) {
                    inter = inter.next;
                }
                temp = inter.data;
                current.data = inter.data;
                inter.data = temp;

                while (inter != current.next && inter.data > inter.next.data) {
                    temp = inter.data;
                    inter.data = inter.next.data;
                    inter.next.data = temp;
                    inter = inter.next;
                }

            }

            current = current.next;
        }
        return head;
    }

}
