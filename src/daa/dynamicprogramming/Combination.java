package daa.dynamicprogramming;

public class Combination {
    public static void main(String []args){
        int[] ar = new int[]{3,5,6,8,2,1};
        int combinationSum = 8;
        // {3,5}, {8}, {6,2}, {5,2,1}
        System.out.println("Total Combinations: " + findAllCombinations(ar, (ar.length - 1), combinationSum, ""));
        // 4
    }

    private static int findAllCombinations(int[] ar, int index, int combinationSum, String str) {

        if (combinationSum < 0) {
            return 0;
        }

        if (combinationSum == 0) {
            System.out.println(new StringBuilder(str).replace(0, 1, "").reverse());
            return 1;
        } else {
            if (index < 0) {
                return 0;
            }
            int value = ar[index];

            return findAllCombinations(ar, index - 1, combinationSum - value, str + ","  + value)
                    + findAllCombinations(ar, index - 1, combinationSum, str);
        }
    }

}