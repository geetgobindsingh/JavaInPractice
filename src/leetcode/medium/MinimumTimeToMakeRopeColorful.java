package leetcode.medium;

public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful obj = new MinimumTimeToMakeRopeColorful();
        System.out.println(obj.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(obj.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(obj.minCost("bbbb", new int[]{5, 4, 8, 1}));
        System.out.println(obj.minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
    }

    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int total = neededTime[j - 1];
            int max = neededTime[j - 1];
            while (j < n && colors.charAt(j - 1) == colors.charAt(j)) {
                total = total + neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }
            i = j - 1;
            totalTime = totalTime + (total - max);
        }
        return totalTime;
    }
}
