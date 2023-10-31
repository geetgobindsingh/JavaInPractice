package gfg.amazonprep.linkedlist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountPairsWhoseSumIsEqualToX extends BaseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list2.add(11);
        list2.add(12);
        list2.add(13);

        System.out.print(countPairs(list1, list2, 15));
    }

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                                 int x) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (Integer i : head1) {
            set.add(i);
        }
        for (Integer i : head2) {
            if (set.contains(x - i)) {
                count++;
            }
        }
        return count;
    }
}
