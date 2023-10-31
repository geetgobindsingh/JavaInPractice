package multithreading.debounce;

public class Debouncer3Test {

    public static void main(String[] args) throws Exception{
        DebouncedRunnable debouncedRunnable = new DebouncedRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }, "mock", 100);
        DebouncedRunnable debouncedRunnable2 = new DebouncedRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }, "mock", 100);

        debouncedRunnable.run();
        Thread.sleep(10);
        debouncedRunnable.run();
        Thread.sleep(100);
        debouncedRunnable.run();

        debouncedRunnable2.run();
        Thread.sleep(10);
        debouncedRunnable2.run();
        Thread.sleep(100);
        debouncedRunnable2.run();
    }
}
