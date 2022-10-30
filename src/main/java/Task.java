import java.util.Date;

public class Task {

    private String description;
    private String deadline;
    private boolean isCompleted = false;

    public Task(){
    }

    public Task(String description, String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        String taskStatus;
        if (!isCompleted) {
            taskStatus = "ongoing";
        } else {
            taskStatus = "completed";
        }
        return description + "  Deadline: " + deadline + " Status: " + taskStatus;
    }
}
