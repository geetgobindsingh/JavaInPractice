package multithreading.requestresponsepattern.core;

import java.util.concurrent.ThreadPoolExecutor;

public interface ExecutorSupplier {
    ThreadPoolExecutor forBackgroundTask();
}
