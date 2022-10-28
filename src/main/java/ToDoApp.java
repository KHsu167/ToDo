import exceptions.IllegalRemovalDetailsEnteredException;
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
            } else if (menuSelection == 5) {
                menu.viewTaskList(toDoList.getTasksList());
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
        }
    }

    private void checkCreateTask() {
        String taskDetailsEnteredByUser = menu.getStringResponseFromUserInput("Enter task details separated by comma: ");
        try {
            toDoList.createTask(taskDetailsEnteredByUser);
            System.out.println("\nSuccessfully created!");
        } catch (IllegalTaskDetailsEnteredException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkRemoveTask() {
        String titleNameEnteredByUser = menu.getStringResponseFromUserInput("Enter the title of the task you wish to remove: ");
        try {
            toDoList.removeTask(titleNameEnteredByUser);
            System.out.println("\nSuccessfully removed!");
        } catch (IllegalRemovalDetailsEnteredException e) {
            System.out.println(e.getMessage());
        }
    }
}


