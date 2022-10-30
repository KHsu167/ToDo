import exceptions.IllegalOptionException;
import exceptions.TaskNumberOutOfRangeException;
import exceptions.IllegalTaskDetailsEnteredException;

import java.util.ArrayList;
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
        if (taskProperties.length == 2) {
            task.setDescription(taskProperties[0].trim());
            task.setDeadline(taskProperties[1].trim());
            tasksList.add(task);

        } else {
            throw new IllegalTaskDetailsEnteredException();
        }
        return task;
    }

    //TODO fix removal logic
    public void removeTask(Integer taskNum) {
        if (taskNum <= 0 || taskNum > tasksList.size()) {
            throw new TaskNumberOutOfRangeException();
        }
        tasksList.remove(taskNum - 1);
    }

    public Task getSelectedTask(Integer taskNum) {
        if (taskNum <= 0 || taskNum > tasksList.size()) {
            throw new TaskNumberOutOfRangeException();
        }
        return tasksList.get(taskNum - 1);
    }

    public void changeStatus(Task task) {
        //TODO add some more logic in here in case task already set to completed
        task.setCompleted(true);
    }

    public void updateTask(Task taskToUpdate, Integer optionToUpdate, String updateInfo) {
        if (optionToUpdate == 1) {
            taskToUpdate.setDescription(updateInfo);
        } else if (optionToUpdate == 2) {
            taskToUpdate.setDeadline(updateInfo);
        } else throw new IllegalOptionException();
    }
}
