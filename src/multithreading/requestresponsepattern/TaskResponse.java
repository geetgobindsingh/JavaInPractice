package multithreading.requestresponsepattern;

public class TaskResponse {
    private final String label;
    private final Priority priority;

    public TaskResponse(String label, Priority priority) {
        this.label = label;
        this.priority = priority;
    }

    public String getLabel() {
        return label;
    }

    public String getPriority() {
        return this.priority.name();
    }
}
