import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList {

    private String toDoListName;
    private Task task;
    private List<Task> tasksList = new ArrayList<>();

    public String getToDoListName() {
        return toDoListName;
    }

    public void setToDoListName(String name) {
        this.toDoListName = name;
    }

    public Task createTask(String name, String description, Date deadline) {
        task.setName(name);
        task.setDescription(description);
        task.setDeadline(deadline);
        return task;
    }

    public List<Task> assignToList(Task task) {
        tasksList.add(task);
        return tasksList;
    }

    public void removeTask(String name) {
        for (int i = 0; i < tasksList.size(); i++) {
            if (tasksList.get(i).getName().equalsIgnoreCase(name)) {
                tasksList.remove(i);
            }
        }
    }
}
