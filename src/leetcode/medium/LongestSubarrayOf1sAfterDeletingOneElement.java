package leetcode.medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement obj = new LongestSubarrayOf1sAfterDeletingOneElement();
        System.out.println(obj.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(obj.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(obj.longestSubarray(new int[]{1, 1, 1}));
        System.out.println(obj.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
        System.out.println(obj.longestSubarray(new int[]{1, 0, 0, 0, 0}));
        System.out.println(obj.longestSubarray(new int[]{0, 0, 0, 0}));
        System.out.println(obj.longestSubarray(new int[]{0, 0, 1, 1}));
    }

    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int longest = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }

            while(zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            longest = Math.max(longest, right - left);
        }
        return longest;
    }
    public int longestSubarray1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] == 1) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i + 1] == 1) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;
    }
}
