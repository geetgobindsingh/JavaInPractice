package gfg.amazonprep.linkedlist;

import java.util.Scanner;

public class FlatteningALinkedList {
    public static void main(String[] args) {
        Node head = new Node(5);
        Node a = new Node(7);
        head.bottom = a;
        Node head2 = new Node(10);
        Node b = new Node(20);
        head2.bottom = b;
        head.next = head2;
        Node head3 = new Node(19);
        Node c = new Node(22);
        Node d = new Node(25);
        head3.bottom = c;
        c.bottom = d;
        head2.next = head3;

        printList(flatten(head));
    }


//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        Node head = null;
//        while (t > 0) {
//            int N = sc.nextInt();
//            int arr[] = new int[N];
//            for (int i = 0; i < N; i++)
//                arr[i] = sc.nextInt();
//
//            Node temp = null;
//            Node tempB = null;
//            Node pre = null;
//            Node preB = null;
//            int flag = 1;
//            int flag1 = 1;
//            for (int i = 0; i < N; i++) {
//                int m = arr[i];
//                m--;
//                int a1 = sc.nextInt();
//                temp = new Node(a1);
//                if (flag == 1) {
//                    head = temp;
//                    pre = temp;
//                    flag = 0;
//                    flag1 = 1;
//                } else {
//                    pre.next = temp;
//                    pre = temp;
//                    flag1 = 1;
//                }
//
//                for (int j = 0; j < m; j++) {
//                    int a = sc.nextInt();
//                    tempB = new Node(a);
//                    if (flag1 == 1) {
//                        temp.bottom = tempB;
//                        preB = tempB;
//                        flag1 = 0;
//                    } else {
//                        preB.bottom = tempB;
//                        preB = tempB;
//                    }
//                }
//
//            }
//            //list.printList();
//            printList(flatten(head));
//
//            t--;
//        }
//    }


    public static void printList(Node reverseList) {
        while (reverseList != null) {
            System.out.print(reverseList.data + " ");
            reverseList = reverseList.next;
        }
    }

    static class Node {
        int data;
        Node next;
        Node bottom;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node flatten(Node root) {
        Node current = root;
        while (current != null) {
            if (current.bottom != null && current.next != null) {
                if (current.bottom.data <= current.next.data) {
                    Node temp = current.next;
                    current.next = current.bottom;
                    current.bottom = null;
                    current = current.next;
                    current.next = temp;
                } else {
                    int temp = current.next.data;
                    current.next.data = current.bottom.data;
                    current.bottom.data = temp;
                    continue;
                }
            } else if (current.next != null) {
                current = current.next;
            } else {
                while (current.bottom != null) {
                    current.next = current.bottom;
                    current.bottom = null;
                    current = current.next;
                }
                current = current.next;
            }
        }
        return root;
    }
}
