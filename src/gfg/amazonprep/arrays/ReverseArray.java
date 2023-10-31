package gfg.amazonprep.arrays;

public class ReverseArray {

    //1,2,3
    //3,2,1

    //1,2,3,4
    //4,3,2,1
    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3};
        System.out.println(printArray(reverseArray(input1)));
        System.out.println(printArray(reverseArrayTwoPointer(input1, 0, input1.length - 1)));
        System.out.println(printArray(reverseArrayRecursion(input1, 0, input1.length - 1)));
        int[] input2 = new int[]{1,2,3,4};
        System.out.println(printArray(reverseArray(input2)));
        System.out.println(printArray(reverseArrayTwoPointer(input2, 0, input2.length - 1)));
        System.out.println(printArray(reverseArrayRecursion(input2, 0, input2.length - 1)));
    }

    private static String printArray(int[] reverseArray) {
        String result = "";
        for (int i : reverseArray) {
            result = result + i + " ";
        }
        return result;
    }

    private static int[] reverseArray(int[] input) {
        int length = input.length;
        int k = length / 2;
        for (int i = 0; i < k; i++) {
            int temp = input[i];
            input[i] = input[length - i - 1];
            input[length - i - 1] = temp;
        }
        return input;
    }

    private static int[] reverseArrayTwoPointer(int[] input, int start, int end) {
        int temp;
        while (start < end) {
            temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
        return input;
    }

    private static int[] reverseArrayRecursion(int[] input, int start, int end) {
        if (start < end) {
            int temp;
            temp = input[start];
            input[start] = input[end];
            input[end] = temp;

            return reverseArrayRecursion(input, ++start, --end);
        }
        return input;
    }
}
