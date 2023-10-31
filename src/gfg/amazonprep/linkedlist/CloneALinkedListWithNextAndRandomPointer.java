package gfg.amazonprep.linkedlist;

import java.util.Scanner;

//TODO: @Difficult @Important
public class CloneALinkedListWithNextAndRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        head.next = a;
        head.arb = b;

        a.next = b;
        a.arb = head;

        b.next = c;
        b.arb = d;

        c.next = d;
        c.arb = b;

        d.arb = a;

//        printList(head);
//        printList(copyList(head));

        head = new Node(1);
        a = new Node(1);
        b = new Node(3);
        c = new Node(4);
        head.next = a;
        head.arb = head;
        a.next = b;
        a.arb = b;
        b.next = c;
        b.arb = a;
        c.arb = b;

        printList(head);
        printList(copyList(head));
    }


    static Node head;

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public static boolean validation(Node head, Node res, Node cloned_add,
                                     Node generated_add) {

        if (generated_add == cloned_add) return false;

        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.data != temp2.data) return false;
            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
            else if (temp1.arb == null && temp2.arb != null)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    //   public static void printList()

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            Node generated_add = null;
            int n = sc.nextInt();
            int q = sc.nextInt();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                Node tempA = head;
                int count = -1;

                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                }
                Node tempB = head;
                count = -1;

                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                }

                // when both a is greater than N
                if (a <= n) tempA.arb = tempB;
            }

            generated_add = head;
            printList(head);
            Node res = copyList(head);
            printList(res);

            Node cloned_add = res;

            if (validation(head, res, cloned_add, generated_add) == true)
                System.out.println("1");
            else
                System.out.println("false");
        }
    }


    public static void printList(Node reverseList) {
        while (reverseList != null) {
            System.out.print(reverseList.data
                    + "-" + (reverseList.next != null ? reverseList.next.data : "") +
                    "-" + (reverseList.arb != null ? reverseList.arb.data : "") + " ");
            reverseList = reverseList.next;
        }
        System.out.println("");
    }


    static class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
            next = arb = null;

        }
    }

    public static Node copyList(Node head) {
        Node current = head;
        Node newHead = null;
        Node newHeadCurrent = head;
        while (current != null) {
            if (newHead == null) {
                newHead = new Node(current.data);
                newHead.arb = current;
                newHeadCurrent = newHead;
            } else {
                newHeadCurrent.next = new Node(current.data);
                newHeadCurrent.next.arb = current;
                newHeadCurrent = newHeadCurrent.next;
            }
            current = current.next;
        }

        newHeadCurrent = newHead;
        while (newHeadCurrent != null) {
            current = head;
            while (current != null) {
                while (current != null && current.arb != null && current.arb.data != newHeadCurrent.data) {
                    current = current.next;
                }
                if (current != null) {
                    if (current.arb != null) {
                        Node cc = newHead;
                        while (cc.arb != null && cc.arb != current) {
                            cc = cc.next;
                        }
                        cc.arb = newHeadCurrent;
                    }
                    current = current.next;
                }
            }
            newHeadCurrent = newHeadCurrent.next;
        }

        return newHead;
    }

}
