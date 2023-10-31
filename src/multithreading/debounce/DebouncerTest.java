package multithreading.debounce;

import java.util.concurrent.TimeUnit;

public class DebouncerTest {
    public static void main(String[] args) {
        final Debouncer<String> debouncer = new Debouncer<String>(new Callback<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        }, 100);
        try {
            debouncer.call("a");
            Thread.sleep(110);
            debouncer.call("a");
            Thread.sleep(100);
            debouncer.call("a");
            debouncer.terminate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
