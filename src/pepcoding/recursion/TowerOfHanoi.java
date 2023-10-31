package pepcoding.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(1, "A", "B", "C");
        System.out.println("\n");
        towerOfHanoi(2, "A", "B", "C");
        System.out.println("\n");
        towerOfHanoi(3, "A", "B", "C");
    }

    private static void towerOfHanoi(int n, String A, String B, String C) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, A, C, B);
        System.out.println(n + " : " + A + " to " + B);
        towerOfHanoi(n - 1, C, B, A);
    }
}
