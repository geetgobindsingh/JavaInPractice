package multithreading.debounce;

import java.util.concurrent.TimeUnit;

public class Debouncer2Test {
    public static void main(String[] args) {
        Debouncer2 debouncer2 = new Debouncer2();
        debouncer2.debounce("a", new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        }, 100, TimeUnit.MILLISECONDS);
        debouncer2.debounce("a", new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        }, 100, TimeUnit.MILLISECONDS);
        debouncer2.debounce("a", new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
            }
        }, 100, TimeUnit.MILLISECONDS);
        debouncer2.debounce("a", new Runnable() {
            @Override
            public void run() {
                System.out.println("D");
            }
        }, 100, TimeUnit.MILLISECONDS);
    }
}
