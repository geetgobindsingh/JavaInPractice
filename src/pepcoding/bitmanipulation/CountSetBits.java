package pepcoding.bitmanipulation;

public class CountSetBits {
    public static void main(String[] args) {
        CountSetBits obj = new CountSetBits();
        System.out.println(obj.countSetBits(57));
    }

    public int countSetBits(int n) { // time O(less than n)
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        while (n > 0) {
            int rmsb = n & -n;
            n = n - rmsb;
            count++;
        }
        return count;
    }
}
