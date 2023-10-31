package leetcode.hard;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class MinimumReplacementsToSortTheArray {
    public static void main(String[] args) {
        MinimumReplacementsToSortTheArray obj = new MinimumReplacementsToSortTheArray();
        System.out.println(obj.minimumReplacement(new int[]{5, 7, 6}));
        System.out.println(obj.minimumReplacement(new int[]{3, 9, 3}));
    }

    public long minimumReplacement(int[] nums) {
        CopyOnWriteArrayList<Integer> list = Arrays.stream(nums)
                .boxed().collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        //displayList(list);
        int min = 0;
        int i = list.size() - 2;
        while (i >= 0) {
            while (i >= 0 && list.get(i) <= list.get(i + 1)) {
                i--;
            }
            if (i < 0) {
                break;
            }
            min++;
            int mid = list.get(i) / 2;
            int b = list.get(i) % 2 == 0 ? mid : mid + 1;
            int a = mid;
            while (b > list.get(i + 1)) {
                b--;
                a++;
            }
            list.add(i, b);
            list.add(i, a);
            list.remove(i + 2);
            //i--;
            //displayList(list);
        }
        return min;
    }

    private void displayList(CopyOnWriteArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i);
        }
        System.out.print("\n");
    }
}
