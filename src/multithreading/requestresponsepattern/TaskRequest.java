package multithreading.requestresponsepattern;

import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TaskRequest {

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public enum TaskOperation {
        READ,
        WRITE,
    }

    private final String tag;
    private final TaskOperation taskOperation;
    private Priority priority;
    private Future future;
    private boolean isCancelled;
    private int sequenceNumber;
    private TaskResult taskResult;
    private boolean retryEnabled;
    private int retryCount;

    public TaskRequest(String tag, TaskOperation taskOperation) {
        this.tag = tag;
        this.taskOperation = taskOperation;
        this.priority = Priority.LOW;
    }

    public String getTag() {
        return tag;
    }

    public void setFuture(Future future) {
        this.future = future;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void cancel(boolean forceCancel) {
        try {
            isCancelled = true;
            if (future != null) {
                future.cancel(forceCancel);
            }
            if (taskResult != null) {
                taskResult.log(tag, "Thread canceled" + " " + getPriority());
            }
            finish();
        } catch (Exception e) {
            deliverErrorResponse(e);
        }
    }

    public TaskRequest add(final TaskResult taskResult) {
        this.taskResult = taskResult;
        return TaskRequestQueue.getInstance().addRequest(this);
    }

    public boolean isRetryEnabled() {
        return retryEnabled;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        if (retryCount > 0) {
            this.retryEnabled = true;
            this.retryCount = retryCount;
        } else {
            this.retryEnabled = false;
            this.retryCount = 0;
        }
    }


    public void destroy() {
        this.taskResult = null;
    }

    public void finish() {
        destroy();
        TaskRequestQueue.getInstance().finish(this);
    }

    public void deliverSuccessResponse() {
        try {
            if (!isCancelled()) {
                if (taskResult != null) {
                    taskResult.onSuccess(new TaskResponse(tag, priority));
                }
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deliverErrorResponse(Exception ex) {
        try {
            if (!isCancelled()) {
                if (taskResult != null) {
                    taskResult.log(tag, ex.getMessage() + " " + getPriority());
                    taskResult.onError(ex);
                }
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void performAction() throws Exception {
        if (!isCancelled()) {
            switch (taskOperation) {
                case READ:
                    readWriteLock.readLock().lock();
                    try {
                        readAction();
                    } catch (Exception ex) {
                        throw new Exception(ex);
                    } finally {
                        readWriteLock.readLock().unlock();
                    }
                    break;
                case WRITE:
                    readWriteLock.writeLock().lock();
                    try {
                        writeAction();
                    } catch (Exception ex) {
                        throw new Exception(ex);
                    } finally {
                        readWriteLock.writeLock().unlock();
                    }
                    break;
            }
        }
    }

    private void readAction() throws Exception {
        Thread.sleep(1000);
    }

    private void writeAction() throws Exception {
        Thread.sleep(2000);
        throw new Exception("Writing Exception");
    }

    public void log(String message) {
        if (taskResult != null) {
            taskResult.log(tag, message);
        }
    }
}
