package multithreading.debounce;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class DebouncedRunnable implements Runnable {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Runnable operation;
    private final String name;
    private final long delayMillis;

    // state
    private long lastRunTime = -1;
    private boolean isQueued = false;

    /**
     * Creates a thread-safe "debounced" version of the given Runnable. This means that when the client calls `run()`:
     * <p>
     * - if it hasn't been called within the past `delayMillis` ms (and there isn't a call queued),
     * then the wrapped Runnable gets called immediately
     * - if there IS a recent call, then we check to see if one is queued
     * - if there is a call queued, we drop the current call
     * - if there is not, we queue up the current call to be called after `delayMillis` ms pass
     * <p>
     * Full behaviour chart:
     * |                                 | `lastRunTime` is a long time ago | lastRunTime is recent  |
     * |                                 |     or `lastRunTime` = -1        |                        |
     * |---------------------------------|----------------------------------|------------------------|
     * | already have call queued        | do nothing                       | do nothing             |
     * | do not already have call queued | run immediately                  | queue call to get run  |
     * <p>
     * Note that `Runnable` accepts no params, meaning each invocation should be interchangeable
     * If we want to extend this mechanism to support calls with args, we will need to decide which params get used
     * when we end up invoking the Runnable (the first set? the last?)
     */
    public DebouncedRunnable(Runnable operation, String name, long delayMillis) {
        this.operation = operation;
        this.name = name;
        this.delayMillis = delayMillis;
    }

    public synchronized void run() {
        long currentTime = getCurrentTimeMillis();
        if (isQueued) {
            // we've already got a call queued, ignore this current one
            System.out.println("dropping {} because it is already queued " + name);
        } else if (shouldRunNow(currentTime)) {
            // we've never called this before, call it now
            lastRunTime = currentTime;
            System.out.println("calling {} immediately " + name);
            operation.run();
        } else {
            // we've called it recently, which suggests that we might have more of these incoming
            // queue this up in to be run `delayMillis` milliseconds, and any incoming calls will get ignored
            System.out.println("queueing {} to be called in {} ms " + name + " " + delayMillis);
            isQueued = true;
            schedule(new Runnable() {
                @Override
                public void run() {
                    scheduledRun();
                }
            }, delayMillis);
        }
    }

    private synchronized void scheduledRun() {
        System.out.println("calling queued task {} after waiting {} ms " + name + " " + delayMillis);
        lastRunTime = getCurrentTimeMillis();
        isQueued = false;
        operation.run();
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
    void schedule(Runnable call, long delayMillis) {
        scheduler.schedule(call, delayMillis, TimeUnit.MILLISECONDS);
    }

    /**
     * package-private for unit testing purposes
     */
    long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
