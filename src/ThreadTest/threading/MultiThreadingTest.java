package ThreadTest.threading;

/**
 * Created by geetgobindsingh on 07/11/17.
 */
public class MultiThreadingTest {

    public static void main(String[] args) {
        int i = 0;
        try {
            for (; i < (2024); ++i) {
                Thread thread = new Thread(new ThreadA());
                thread.start();
                thread.join();
            }
        } catch (OutOfMemoryError ex) {
            System.out.println("OOM Exception :" + ex.getCause() + " at " + i);
        } catch (Exception ex) {
            System.out.println("Exception :" + ex.getCause() + " at " + i);
        }
    }


    static class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId()+" id and "+ Thread.currentThread().getName());
        }
    }
}
