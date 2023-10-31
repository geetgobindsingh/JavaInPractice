package helper;

public class ArrayUtil {
    private ArrayUtil() {

    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(long[] array) {
        for (long element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(float[] array) {
        for (float element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static <T> void swap(T[] ar, int i, int j) {
        T temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void swap(long[] ar, int i, int j) {
        long temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void swap(double[] ar, int i, int j) {
        double temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void swap(float[] ar, int i, int j) {
        float temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
