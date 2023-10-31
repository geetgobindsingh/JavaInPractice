package multithreading.requestresponsepattern.core;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {

    private final int mThreadPriority;

    public PriorityThreadFactory(int mThreadPriority) {
        this.mThreadPriority = mThreadPriority;
    }

    @Override
    public Thread newThread(@NotNull Runnable runnable) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    Process.setThreadPriority(mThreadPriority); // Android
                    Thread.currentThread().setPriority(mThreadPriority);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                runnable.run();
            }
        });
    }
}
