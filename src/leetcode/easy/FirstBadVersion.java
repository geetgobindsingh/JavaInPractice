package leetcode.easy;

public class FirstBadVersion {
    public static void main(String[] args) {
        FirstBadVersion obj = new FirstBadVersion();
        System.out.println(obj.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean isBadVersion(int n) {
        return n == 4;
    }
}
