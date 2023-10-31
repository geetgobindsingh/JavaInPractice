package multithreading.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    private final ScheduledExecutorService scheduledExecutorService;
    private final int timeDelay;
    private final TimeUnit timeUnit;
    private boolean terminated = false;

    public Scheduler(int numberOfThreads, int timeDelay, TimeUnit timeUnit) {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        this.timeDelay = timeDelay;
        this.timeUnit = timeUnit;
    }

    public void schedule(Runnable runnable) {
        this.scheduledExecutorService.scheduleWithFixedDelay(runnable, 0, timeDelay, timeUnit);
    }

    public void schedule(Runnable runnable, int initialDelay) {
        this.scheduledExecutorService.scheduleWithFixedDelay(runnable, initialDelay, timeDelay, timeUnit);
    }

    public void terminate() {
        this.terminated = true;
        this.scheduledExecutorService.shutdown();
    }


    public boolean isTerminated() {
        return this.terminated;
    }
}
