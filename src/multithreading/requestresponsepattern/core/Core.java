package multithreading.requestresponsepattern.core;

public class Core {
    private static Core sInstance = null;
    private final ExecutorSupplier executorSupplier;

    private Core() {
        this.executorSupplier = new DefaultExecutorSupplier();
    }

    public static Core getInstance() {
        if (sInstance == null) {
            synchronized (Core.class) {
                if (sInstance == null) {
                    sInstance = new Core();
                }
            }
        }
        return sInstance;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return executorSupplier;
    }

    public static void shutDown() {
        if (sInstance != null) {
            sInstance = null;
        }
    }
}
