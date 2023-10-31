package multithreading.requestresponsepattern;

import multithreading.requestresponsepattern.logging.CoreLogger;

import java.util.ArrayList;
import java.util.List;

public class TestRequestResponsePattern implements TaskResult {


    public static void main(String[] args) throws InterruptedException {
        TestRequestResponsePattern object = new TestRequestResponsePattern();
        List<TaskRequest> taskRequests = new ArrayList<>();
        taskRequests.add(getTaskRequest("1", Priority.LOW, TaskRequest.TaskOperation.READ));
        taskRequests.add(getTaskRequest("2", Priority.LOW, TaskRequest.TaskOperation.READ));
        taskRequests.add(getTaskRequest("3", Priority.MEDIUM, TaskRequest.TaskOperation.WRITE));
        taskRequests.add(getTaskRequest("4", Priority.HIGH, TaskRequest.TaskOperation.READ));
        taskRequests.add(getTaskRequest("5", Priority.IMMEDIATE, TaskRequest.TaskOperation.WRITE));
        taskRequests.add(getTaskRequest("6", Priority.HIGH, TaskRequest.TaskOperation.READ));
        for (TaskRequest taskRequest : taskRequests) {
            if (taskRequest.getPriority() == Priority.IMMEDIATE) {
                Thread.sleep(3000);
            }
            taskRequest.add(object);
        }
        while (!TaskRequestQueue.getInstance().isEmpty()) {
            //keep running
        }
        System.out.println("Program Terminated");
    }

    public static TaskRequest getTaskRequest(String label, Priority priority, TaskRequest.TaskOperation taskOperation) {
        TaskRequest taskRequest = new TaskRequest(label, taskOperation);
        taskRequest.setPriority(priority);
        if (taskOperation.equals(TaskRequest.TaskOperation.WRITE)) {
            taskRequest.setRetryCount(5);
        }
        return taskRequest;
    }

    @Override
    public void onSuccess(TaskResponse response) {
        CoreLogger.getInstance().d("Hurray Success by " + response.getLabel() + " " + response.getPriority());
    }

    @Override
    public void onError(Exception ex) {
    }

    @Override
    public void log(String banner, String message) {
        CoreLogger.getInstance().d(banner + " " + message);
    }
}
