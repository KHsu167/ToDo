import exceptions.IllegalOptionException;
import exceptions.TaskNumberOutOfRangeException;
import exceptions.IllegalTaskDetailsEnteredException;

public class ToDoApp {

    private Menu menu;
    private ToDoList toDoList;

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp(new Menu(), new ToDoList());
        app.run();
    }

    public ToDoApp(Menu menu, ToDoList toDoList) {
        this.menu = menu;
        this.toDoList = toDoList;
    }

    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            menu.printMainMenu();
            menuSelection = menu.promptForMenuSelection("Select an option: ");
            if (menuSelection == 1) {
                checkCreateTask();
            } else if (menuSelection == 2) {
                checkRemoveTask();
            } else if (menuSelection == 3) {
                checkUpdateTask();
            } else if (menuSelection == 4) {
                menu.viewTaskList(toDoList.getTasksList());
            } else if (menuSelection == 5) {
                checkTaskStatus();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
        }
    }

    private void checkCreateTask() {
        String taskDetailsEnteredByUser = menu.getStringResponseFromUserInput("Enter description and deadline separated by comma: ");

        try {
            toDoList.createTask(taskDetailsEnteredByUser);
            System.out.println("\nSuccessfully created!");
        } catch (IllegalTaskDetailsEnteredException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkRemoveTask() {
        Integer titleNumEnteredByUser = menu.getIntResponseFromUserInput("Enter the task number you wish to remove: ");

        try {
            toDoList.removeTask(titleNumEnteredByUser);
            System.out.println("\nSuccessfully removed!");
        } catch (TaskNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkUpdateTask() {
        Integer titleNumEnteredByUser = menu.getIntResponseFromUserInput("Enter the task number you wish to update: ");
//            try {
//                Task taskToUpdate = toDoList.getSelectedTask(titleNumEnteredByUser);
//            } catch (TaskNumberOutOfRangeException e) {
//                System.out.println(e.getMessage());
//            }

        menu.updateMenu2();
        while (true) {
            Integer optionSelected = menu.getIntResponseWithNoPrompt();
            try {
                //TODO fix logic to catch tasknumoutofrange exception
                Task taskToUpdate = toDoList.getSelectedTask(titleNumEnteredByUser);
                String updateInfo = menu.getStringResponseFromUserInput("Enter new info: ");
                toDoList.updateTask(taskToUpdate, optionSelected, updateInfo);
                System.out.println("\nSuccessfully updated!");
                break;
            } catch (TaskNumberOutOfRangeException | IllegalOptionException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private void checkTaskStatus() {
        Integer titleNumEnteredByUser = menu.getIntResponseFromUserInput("Enter the task number you wish to change: ");

        try {
            Task taskToBeChanged = toDoList.getSelectedTask(titleNumEnteredByUser);
            String message = toDoList.changeStatus(taskToBeChanged);
            System.out.println("\n(" + titleNumEnteredByUser + ") " + message);
        } catch (TaskNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}


