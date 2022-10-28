import exceptions.IllegalRemovalDetailsEnteredException;
import exceptions.IllegalTaskDetailsEnteredException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList {

    //  private String toDoListName;
    private List<Task> tasksList = new ArrayList<>();

    public List<Task> getTasksList() {
        return tasksList;
    }

    public Task createTask(String userResponse) {
        Task task = new Task();
        String[] taskProperties = userResponse.split(",");
        if (taskProperties.length == 3) {
            task.setTitle(taskProperties[0].trim());
            task.setDescription(taskProperties[1].trim());
            task.setDeadline(taskProperties[2].trim());
            tasksList.add(task);
        } else {
            throw new IllegalTaskDetailsEnteredException();
        }
        return task;
    }

    public void removeTask(String name) {
        boolean isItAValidName = false;
        for (int i = 0; i < tasksList.size(); i++) {
            if (tasksList.get(i).getTitle() != null && tasksList.get(i).getTitle().equals(name)) {
                tasksList.remove(tasksList.get(i));
                isItAValidName = true;
            }
        }
        if (!isItAValidName) {
            throw new IllegalRemovalDetailsEnteredException();
        }

    }

//    public boolean updateTask(Task updatedTask) {
//
//    }


}
