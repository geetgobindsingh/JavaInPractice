package gfg.amazonprep.linkedlist;

public class DeleteWithoutHeadPointer {

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
        printList(node);
        deleteNode(node4);
        printList(node);
    }

    private static void printList(Node reverseList) {
        while (reverseList != null) {
            System.out.print(reverseList.data + " ");
            reverseList = reverseList.next;
        }
        System.out.println();
    }

    private static void deleteNode(Node node) {
       if (node != null && node.next != null) {
           node.data = node.next.data;
           node.next = node.next.next;
       }
    }

    private static void deleteNode1(Node node) {
        Node prev = null;
        while (node != null && node.next != null) {
            prev = node;
            node.data = node.next.data;
            node = node.next;
        }
        if (prev != null){
            prev.next = null;
        }
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

