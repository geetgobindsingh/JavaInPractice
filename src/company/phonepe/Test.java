package company.phonepe;

import java.util.*;
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,6,6,4};
        int k = 2;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : set) {
            if (pq.size() < k) {
                pq.offer(s);
            } else {
                pq.remove();
                pq.offer(s);
            }
        }
        if (pq.size() > 0) {
            System.out.print(pq.peek());
        } else {
            System.out.print(-1);
        }
    }
    /*public static void main1(String[] args) {
        System.out.println();
        String haystack = "sadb", needle = "sad";
        int m = haystack.length();
        int n = needle.length();
        boolean needleFound = false;
        for (int i = 0 ; i < m; i++) {
            char c = haystack.charAt(i);

            if (c == needle.charAt(0)) {
                needleFound = true;
                int k = i;
                int j = 0;
                for (; j < n && k < m; j++) {
                     System.out.println(j + " : " + k);
                     System.out.println(needle.charAt(j) + " "+ haystack.charAt(k));
                    if (needle.charAt(j) == haystack.charAt(k++)) {
                        continue;
                    } else {
                        needleFound = false;
                        break;
                    }
                }
                if (needleFound && j == n) {
                    System.out.println(i);
                    break;
                } else {
                    needleFound = false;
                    i = k;
                }
            }

        }
        if (!needleFound) {
            System.out.println(-1);
        }
    }*/
}
