package multithreading.debounce;

public class DebounceTest {
    public static void main(String[] args) throws Exception {
        Debounce<String> debounce = new Debounce<>(object -> {
            System.out.println(object + " World!");
        }, 100);

        debounce.execute("Hello A");
        Thread.sleep(50);
        debounce.execute("Hello B");
        Thread.sleep(90);
        debounce.execute("Hello C");
        Thread.sleep(150);
        debounce.execute("Hello D");

        debounce.terminate();
    }
}
