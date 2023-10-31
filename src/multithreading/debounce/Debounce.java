package multithreading.debounce;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Debounce<T> {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Operation<T> operation;
    private final long delayMillis;

    // state
    private long lastRunTime = -1;
    private boolean isQueued = false;
    private boolean isCancelled = false;

    public Debounce(Operation<T> operation, long delayMillis) {
        this.operation = operation;
        this.delayMillis = delayMillis;
    }

    public synchronized void execute(T object) {
        if (isCancelled) {
            return;
        }
        long currentTime = getCurrentTimeMillis();
        if (isQueued) {
            // we've already got a call queued, ignore this current one
        } else if (shouldRunNow(currentTime)) {
            // we've never called this before, call it now
            lastRunTime = currentTime;
            operation.run(object);
        } else {
            // we've called it recently, which suggests that we might have more of these incoming
            // queue this up in to be run `delayMillis` milliseconds, and any incoming calls will get ignored
            isQueued = true;
            schedule(new Runnable() {
                @Override
                public void run() {
                    scheduledRun(object);
                }
            }, delayMillis);
        }
    }

    public void terminate() {
        this.isCancelled = true;
        scheduler.shutdown();
    }

    private synchronized void scheduledRun(T object) {
        lastRunTime = getCurrentTimeMillis();
        isQueued = false;
        if (isCancelled) {
            return;
        }
        operation.run(object);
    }

    /**
     * Should run now if we've never run it before or we've run it more than `delayMillis` ms in the past
     */
    private boolean shouldRunNow(long currentTime) {
        return lastRunTime == -1 || lastRunTime + delayMillis < currentTime;
    }

    /**
     * package-private for unit testing purposes
     */
    private void schedule(Runnable call, long delayMillis) {
        scheduler.schedule(call, delayMillis, TimeUnit.MILLISECONDS);
    }

    /**
     * package-private for unit testing purposes
     */
    private long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }


    public interface Operation<T> {
        void run(T object);
    }
}
