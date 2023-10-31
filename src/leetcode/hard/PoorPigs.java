package leetcode.hard;

import java.util.Arrays;

public class PoorPigs {

    public static void main(String[] args) {
        PoorPigs obj = new PoorPigs();
        System.out.println("Ans:" + obj.poorPigs(4,15,15));
        System.out.println("Ans:" + obj.poorPigs(4,15,30));
        System.out.println("Ans:" + obj.poorPigs(1000,15,60));
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        int res = 0;
        for (int p = 1; p < buckets; p *= base) {
            ++res;
        }
        return res;
    }
}
