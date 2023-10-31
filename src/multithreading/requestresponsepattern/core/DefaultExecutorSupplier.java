package multithreading.requestresponsepattern.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultExecutorSupplier implements ExecutorSupplier {

    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static int THREAD_PRIORITY_BACKGROUND = 10;
    final ThreadPoolExecutor mBackgroundTaskPool;

    public DefaultExecutorSupplier() {
        ThreadFactory backgroundPriorityThreadFactory = new PriorityThreadFactory(THREAD_PRIORITY_BACKGROUND);
        this.mBackgroundTaskPool = new PriorityThreadPoolExecutor(
                1,
                1,
                60L,
                TimeUnit.SECONDS,
                backgroundPriorityThreadFactory
        );

    }

    @Override
    public ThreadPoolExecutor forBackgroundTask() {
        return this.mBackgroundTaskPool;
    }
}
