package random;

public class CheckedException {
    public static void main(String[] args) {
        try {
            try {
                System.out.print("1");
                throw new RuntimeException("");
            } catch (RuntimeException ex) {
                System.out.print("2");
                throw new NullPointerException();
            }
        } catch (Exception ex) {
            System.out.print("4");
        }

        System.out.print("\n");
        System.out.print(30<<1);
    }
}
