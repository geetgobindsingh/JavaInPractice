package multithreading.requestresponsepattern;

public class PriorityRunnable implements Runnable {

    private final TaskRequest taskRequest;
    private int retryCounter = 0;

    public PriorityRunnable(TaskRequest taskRequest) {
        this.taskRequest = taskRequest;
    }

    @Override
    public void run() {
        while (!taskRequest.isRetryEnabled() || shouldRetry()) {
            try {

                taskRequest.performAction();

                if (Integer.parseInt(taskRequest.getTag()) % 2 != 0 && Integer.parseInt(taskRequest.getTag()) % 3 == 0) {
                    taskRequest.cancel(true);
                } else if (Integer.parseInt(taskRequest.getTag()) % 2 != 0) {
                    throw new Exception("Odd Threads");
                }
                taskRequest.deliverSuccessResponse();
                break;
            } catch (Exception e) {
                retryCounter++;
                if (retryCountExhausted()) {
                    taskRequest.deliverErrorResponse(e);
                    break;
                } else {
                    Thread.yield();
                    taskRequest.log("retry count " + retryCounter);
                }
            }
        }
    }

    private boolean shouldRetry() {
        return (retryCounter < taskRequest.getRetryCount());
    }

    private boolean retryCountExhausted() {
        return !shouldRetry();
    }

    public Priority getPriority() {
        return taskRequest.getPriority();
    }

    public TaskRequest getTaskRequest() {
        return taskRequest;
    }
}
