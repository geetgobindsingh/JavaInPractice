package random;

/**
 * Created by geetgobindsingh on 28/08/17.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        ExceptionTest obj = new ExceptionTest();
        obj.methodOne();
    }

    public void methodOne() {
        try {
            methodTwo();
        }   catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void methodTwo() {
    try {
        int[] str = new int[2];
        throw new NullPointerException();
    }   catch (Exception ex) {
        System.out.println(ex.getCause());
    }
    }
}
