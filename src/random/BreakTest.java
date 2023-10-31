package random;

public class BreakTest {
    public static void main(String[] args) {
        while (true) {
            System.out.println("A");
            if (true) {
                break;
            }
            System.out.println("B");
        }
    }
}
