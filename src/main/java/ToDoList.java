import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList {

//  private String toDoListName;
    private Task task;
    private List<Task> tasksList = new ArrayList<>();

    public List<Task> getTasksList() {
        return tasksList;
    }

    public Task createTask(String userResponse) {
        if (userResponse != null) {
            String[] taskProperties = userResponse.split(", ");
            task.setTitle(taskProperties[0]);
            task.setDescription(taskProperties[1]);
            task.setDeadline(taskProperties[2]);
        }
        return null;
    }

    public void removeTask(String name) {
        for (int i = 0; i < tasksList.size(); i++) {
            if (tasksList.get(i).getTitle() != null && tasksList.get(i).getTitle().contains(name)) {
                tasksList.remove(tasksList.get(i));
            }
        }
    }

//    public boolean updateTask(Task updatedTask) {
//
//    }

    public List<Task> assignToList(Task task) {
        tasksList.add(task);
        return tasksList;
    }

}
