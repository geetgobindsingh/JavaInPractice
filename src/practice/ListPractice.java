package practice;

import java.util.*;
public class ListPractice {
    public static void main(String[] args) {
        ListPractice obj = new ListPractice();
        obj.linkedList();
    }

    public void linkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.addFirst(-1);
        linkedList.addLast(3);
        for (Integer i : linkedList) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public void arrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
