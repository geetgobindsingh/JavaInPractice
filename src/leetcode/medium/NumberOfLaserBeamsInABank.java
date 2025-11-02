package leetcode.medium;

public class NumberOfLaserBeamsInABank {
    public static void main(String[] args) {
        NumberOfLaserBeamsInABank obj = new NumberOfLaserBeamsInABank();
        System.out.println(obj.numberOfBeams(new String[]{"011001","000000","010100","001000"}));
        System.out.println(obj.numberOfBeams(new String[]{"000","111","000"}));
    }

    public int numberOfBeams(String[] bank) {
        int left = 0;
        int right = 0;
        int sum = 0;
        for (String lazers : bank) {
            if (lazers.contains("1")) {
                int count = 0;
                for (char lazer : lazers.toCharArray()) {
                    if (lazer == '1') {
                        count++;
                    }
                }
                if (left == 0) {
                    left = count;
                } else if (right == 0) {
                    right = count;
                }

                if (left != 0 && right != 0) {
                    sum = sum + (left * right);
                    left = right;
                    right = 0;
                }
            }
        }
        return sum;
    }
}
