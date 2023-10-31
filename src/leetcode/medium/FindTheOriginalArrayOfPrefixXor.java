package leetcode.medium;

public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        FindTheOriginalArrayOfPrefixXor obj = new FindTheOriginalArrayOfPrefixXor();
        for (int i : obj.findArray(new int[]{5, 2, 0, 3, 1})) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i]  = pref[i] ^ pref[i - 1];
        }
        return arr;
    }
}
