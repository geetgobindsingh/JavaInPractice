package daa.dynamicprogramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        /*
        Input  : arr[] = {3, 10, 2, 1, 20}
        Output : Length of LIS = 3
        The longest increasing subsequence is 3, 10, 20
         */
        int ar[] = new int[]{3, 10, 2, 1, 20};

        System.out.println(getLongestIncreasingSubsequence(ar, ar.length - 1, ""));
    }

    private static Output getLongestIncreasingSubsequence(int[] ar, int index, String result) {
        if (index < 0) {
            return new Output(result);
        }



        return null;
    }


    static class Output {
        String sequence;

        public Output(String sequence) {
            this.sequence = sequence;
        }

        @Override
        public String toString() {
            return "Length of LIS = " + sequence.length() + "\n" + "The longest increasing subsequence is " + sequence;
        }
    }
}
