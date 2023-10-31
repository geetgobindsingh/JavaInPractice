package multithreading.requestresponsepattern;

import multithreading.requestresponsepattern.core.Core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRequestQueue {
    private final static String TAG = "TaskRequestQueue";
    private final Set<TaskRequest> mCurrentRequests = new HashSet<TaskRequest>();
    private AtomicInteger mSequenceGenerator = new AtomicInteger();

    private static TaskRequestQueue sInstance = null;

    public static TaskRequestQueue getInstance() {
        if (sInstance == null) {
            synchronized (TaskRequestQueue.class) {
                if (sInstance == null) {
                    sInstance = new TaskRequestQueue();
                }
            }
        }
        return sInstance;
    }

    public synchronized boolean isEmpty() {
        synchronized (mCurrentRequests) {
            return mCurrentRequests.isEmpty();
        }
    }

    public void cancelAll(boolean forceCancel) {
        synchronized (mCurrentRequests) {
            try {
                for (Iterator<TaskRequest> iterator = mCurrentRequests.iterator(); iterator.hasNext(); ) {
                    TaskRequest taskRequest = iterator.next();
                    taskRequest.cancel(forceCancel);
                    if (taskRequest.isCancelled()) {
                        taskRequest.destroy();
                        iterator.remove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public TaskRequest addRequest(TaskRequest taskRequest) {
        synchronized (mCurrentRequests) {
            try {
                taskRequest.log("is Added");
                mCurrentRequests.add(taskRequest);
            } catch (Exception e) {
                taskRequest.deliverErrorResponse(e);
                e.printStackTrace();
            }
        }
        try {
            taskRequest.setSequenceNumber(getSequenceNumber());
            taskRequest.setFuture(Core.getInstance().getExecutorSupplier()
                    .forBackgroundTask()
                    .submit(new PriorityRunnable(taskRequest)));
        } catch (Exception e) {
            taskRequest.deliverErrorResponse(e);
            e.printStackTrace();
        }
        return taskRequest;
    }

    public int getSequenceNumber() {
        return mSequenceGenerator.incrementAndGet();
    }

    public void finish(TaskRequest taskRequest) {
        synchronized (mCurrentRequests) {
            try {
                mCurrentRequests.remove(taskRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
