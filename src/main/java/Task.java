import java.util.Date;

public class Task {

    private String title;
    private String description;
    private String deadline;
    private boolean isCompleted = false;

    public Task(){
    }

    public Task(String name, String description, String deadline) {
        this.title = name;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return title + ": " + description + "  Deadline: " + deadline + " Status: " + taskStatus;
    }
}
