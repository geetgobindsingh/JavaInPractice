package multithreading.requestresponsepattern.logging;

public class CoreLogger {

    private static CoreLogger sInstance = null;

    public static CoreLogger getInstance() {
        if (sInstance == null) {
            synchronized (CoreLogger.class) {
                if (sInstance == null) {
                    sInstance = new CoreLogger();
                }
            }
        }
        return sInstance;
    }

    public void d(String message) {
        System.out.println(message);
    }

    public void w(String message) {
        System.out.println("WARNING: " + message);
    }

    public void i(String message) {
        System.out.println("INFO: " + message);
    }

    public void e(String message) {
        System.out.println("ERROR: " + message);
    }
}
