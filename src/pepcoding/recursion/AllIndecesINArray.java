package pepcoding.recursion;

public class AllIndecesINArray {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 4, 5, 3, 6, 7, 8, 3, 9};
        int x = 3;
        int index = 0;
        int fsf = 0; //foundSoFar
        int[] result = findAllIndeces(ar, x, index, fsf);
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }

    private static int[] findAllIndeces(int[] ar, int x, int index, int fsf) {
        // base condition
        if (index == ar.length) {
            return new int[fsf];
        }
        if (ar[index] == x) {
            int[] arr = findAllIndeces(ar, x, index + 1, fsf + 1);
            arr[fsf] = index;
            return arr;
        } else {
            int[] arr = findAllIndeces(ar, x, index + 1, fsf);
            return arr;
        }
    }
}
