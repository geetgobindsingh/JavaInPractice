package multithreading.requestresponsepattern;

public interface TaskResult {
    void onSuccess(TaskResponse taskResponse);

    void onError(Exception ex);

    void log(String banner, String message);
}
