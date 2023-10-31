package random;

public class RuntimeExcept {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception ex) {
            System.out.println("Exception Handled");
            if (ex instanceof RuntimeException) {
               // ex.printStackTrace();
            }
        }

        try {
            throw new Error();
        } catch (Exception ex) {
            System.out.println("Error Handled");
            if (ex instanceof RuntimeException) {
                // ex.printStackTrace();
            }
        }
        finally {
            System.out.println("Error not handled");
        }
    }
}
