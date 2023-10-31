package dailyproblems;

public class DayTwo {

    /*
    Problem Statement:
    Given an array of integers, return a new array
    such that each element at index i of the new array
    is the product of all the numbers in the original array except the one at i.
    Solve it without using division and in O(n) time.

    For example, if our input was [1, 2, 3, 4, 5],
    the expected output would be [120, 60, 40, 30, 24].
    If our input was [3, 2, 1], the expected output would be [2, 3, 6].
     */
    public static void main(String[] args) {
        int input[] = new int[]{1, 2, 3, 4, 5};
        int output[] = getOutput(input);
        for (int out : output) {
            System.out.print(out + " ");
        }
    }

    private static int[] getOutput(int[] input) {
        int[] output = new int[input.length];
        int product = 1;
        output[0] = product;
        int length = input.length;
        for (int index = 0; index < (length - 1); ++index) {
            product *= input[index];
            if (index > 0) {
                output[index] = input[index - 1];
            }
        }
        output[length - 1] = product;
        product = input[length - 1];
        for (int index = (length - 2); index >= 0; --index) {
            output[index] = product * output[index];
            product *= input[index];
        }
        return output;
    }
}
