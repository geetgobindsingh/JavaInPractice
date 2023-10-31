package pepcoding.recursion;

public class FirstIndexOfD {
    public static void main(String[] args) {
        System.out.println(firstIndexOf(new int[]{3, 2, 8, 7, 5, 4, 8}, 8, 0));
        System.out.println(lastIndexOf(new int[]{3, 2, 8, 7, 5, 4, 8}, 8, 0));
        System.out.println(lastIndexOf2(new int[]{3, 2, 8, 7, 5, 4, 8}, 8, 6));
    }

    public static int firstIndexOf(int[] ar, int d, int i) {
        if (i == ar.length) return -1;
        int index = firstIndexOf(ar, d, i + 1);
        return (d == ar[i] ? i : index);
    }

    public static int lastIndexOf(int[] ar, int d, int i) {
        if (i == ar.length) return -1;
        int index = lastIndexOf(ar, d, i + 1);
        if (index > -1) {
            return index;
        } else {
            return (d == ar[i] ? i : index);
        }
    }

    public static int lastIndexOf2(int[] ar, int d, int i) {
        if (i == 0) return -1;
        int index = firstIndexOf(ar, d, i - 1);
        return (d == ar[i] ? index : -1);
    }
}
