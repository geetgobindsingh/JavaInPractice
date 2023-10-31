package gfg.amazonprep.arrays;

public class MinMaxArrayElement {

    static class Pair {
        int min;
        int max;

        public Pair() {

        }

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public String toString() {
            return min + " " + max;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 7, 6, 5, 1};
        System.out.println(finMinMax(input));
        System.out.println(findMinMaxTournament(input, 0, input.length - 1));
        System.out.println(findMinMaxPairComparision(input));
    }

    private static Pair finMinMax(int[] input) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < input.length; i++) {
            if (min > input[i]) {
                min = input[i];
            }
            if (max < input[i]) {
                max = input[i];
            }
        }
        return new Pair(min, max);
    }

    /*
    Divide the array into two parts and compare the maximums and minimums of the two parts
     to get the maximum and the minimum of the whole array.
     */
    private static Pair findMinMaxTournament(int[] input, int start, int end) {
        Pair minMaxPair = new Pair();

        if (start == end) {
            minMaxPair.min = input[start];
            minMaxPair.max = input[start];
            return minMaxPair;
        }

        if (end == start + 1) {
            if (input[start] < input[end]) {
                minMaxPair.min = input[start];
                minMaxPair.max = input[end];
            } else {
                minMaxPair.min = input[end];
                minMaxPair.max = input[start];
            }
            return minMaxPair;
        }

        int mid = (start + (end - start) / 2);
        Pair minMaxPairLeft = findMinMaxTournament(input, start, mid);
        Pair minMaxPairRight = findMinMaxTournament(input, mid + 1, end);

        if (minMaxPairLeft.min < minMaxPairRight.min) {
            minMaxPair.min = minMaxPairLeft.min;
        } else {
            minMaxPair.min = input[start];
            minMaxPair.min = minMaxPairRight.min;
        }

        if (minMaxPairLeft.max < minMaxPairRight.max) {
            minMaxPair.max = minMaxPairRight.max;
        } else {
            minMaxPair.max = minMaxPairLeft.max;
        }

        return minMaxPair;
    }


    private static Pair findMinMaxPairComparision(int[] input) {
        Pair minMaxPair = new Pair();
        int end = input.length;
        int start = 0;
        if (end % 2 == 0) {
            if (input[0] < input[1]) {
                minMaxPair.min = input[0];
                minMaxPair.max = input[1];
            } else {
                minMaxPair.min = input[1];
                minMaxPair.max = input[0];
            }
            start = 2;
        } else {
            minMaxPair.min = input[0];
            minMaxPair.max = input[0];
            start = 1;
        }

        while (start < end - 1) {
            if (input[start] > input[start + 1]) {
                if (input[start] > minMaxPair.max) {
                    minMaxPair.max = input[start];
                }
                if (input[start + 1] < minMaxPair.min) {
                    minMaxPair.min = input[start + 1];
                }
            } else {
                if (input[start + 1] > minMaxPair.max) {
                    minMaxPair.max = input[start + 1];
                }
                if (input[start] < minMaxPair.min) {
                    minMaxPair.min = input[start];
                }
            }
            start = start + 2;
        }
        return minMaxPair;
    }


}
