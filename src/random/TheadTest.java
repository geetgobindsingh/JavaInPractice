package random;

/**
 * Created by geetgobindsingh on 17/08/17.
 */
public class TheadTest {
    String s1 = "s1";
    public static void main(String[] args) {
        TheadTest theadTest = new TheadTest();
        theadTest.functionCall();
    }

    public void functionCall() {
        final String s2 = "s2";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String s3 = s1 + s2;
                System.out.println(s3);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s3 = s1 + s2;
                String s4 = s2;
                s4 = "1";
                System.out.println(s3);
            }
        }).start();
    }
}
