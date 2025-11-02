package leetcode.easy;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();
        System.out.println(obj.hammingWeight(0x00000000000000000000000000001011));
        //System.out.println(obj.hammingWeight(0x00000000000000000000000010000000));
        //System.out.println(obj.hammingWeight(11111111111111111111111111111101));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }
}
