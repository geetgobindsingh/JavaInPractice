package gfg.amazonprep.backtracking;

public class TargetSumSubset {
    public static void main(String[] args) {
        int ar[] = new int[]{5, 10, 20, 30, 40, 50};
        System.out.println(findAlSubSets(ar, 50));
        System.out.println(findAlSubSets(ar, 70));
    }

    private static String findAlSubSets(int[] ar, int target) {
        return findAlSubSets(0, ar, "", 0, target);
    }

    private static String findAlSubSets(int index, int[] ar, String output, int sum, int target) {
        if (index == ar.length) {
            if (sum == target) {
                output = output + "\n";
                return output;
            }
            return "";
        }
        return findAlSubSets(index + 1, ar, output, sum, target)
                + ""
                + findAlSubSets(index + 1, ar, output + ar[index] + ",", sum + ar[index], target);
    }
}
