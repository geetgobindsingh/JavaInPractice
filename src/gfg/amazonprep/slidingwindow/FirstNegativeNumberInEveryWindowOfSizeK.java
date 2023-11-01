package gfg.amazonprep.slidingwindow;

public class FirstNegativeNumberInEveryWindowOfSizeK {
    public static void main(String[] args) {
        FirstNegativeNumberInEveryWindowOfSizeK obj = new FirstNegativeNumberInEveryWindowOfSizeK();
        for (int i : obj.firstNegativeNumber(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : obj.firstNegativeNumber(new int[]{-8, 2, 3, -6, 10}, 2)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : obj.firstNegativeNumber(new int[]{4844, -458, -48, 124, -415}, 2)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int[] firstNegativeNumber(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int iter = 0;
        int lastNegative = 0;
        for (int left = 0, right = 0; right < n; right++) {
            if ((right - left + 1) <= k) {
                if (lastNegative == 0 && nums[right] < 0) {
                    lastNegative = nums[right];
                }
            }
            if ((right - left + 1) == k) {
                result[iter++] = lastNegative;
                left++;
                lastNegative = 0;
                for (int i = left; i <= right + 1 && i < n; i++) {
                    if (nums[i] < 0) {
                        lastNegative = nums[i];
                        break;
                    }
                }
            }
        }
        return result;
    }


}
