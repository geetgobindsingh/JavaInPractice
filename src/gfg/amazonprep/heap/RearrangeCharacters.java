package gfg.amazonprep.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RearrangeCharacters {
    public static void main(String[] args) {
        System.out.print(rearrangeCharacters("pyliuaewnvcewwpagbjgozqooopgxgqmqqq"));
    }

    static boolean rearrangeCharacters(String str) {
        System.out.println(str.length());
        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < str.length(); ++index) {
            minHeap.add(str.charAt(index));
            maxHeap.add(str.charAt(index));
        }

        int mid = (str.length() - 1) / 2;
        while (mid > 1) {
            mid--;
            Character c1 = minHeap.poll();
            Character c2 = maxHeap.poll();
            System.out.println(mid + " " + c1 + " " + c2);
            if (c1 == c2) {
                return false;
            }
        }
        return true;
    }
}
