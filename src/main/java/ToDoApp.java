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
                //TODO prompt user to put in title, description, deadline and pass it to createTask
                toDoList.assignToList(toDoList.createTask(menu.getStringResponseFromUserInput("Enter task details separated by comma: ")));
            } else if (menuSelection == 2) {
                //TODO prompt user to enter title of task to remove
                toDoList.removeTask(menu.getStringResponseFromUserInput("Enter the title of the task you wish to remove: "));
            } else if (menuSelection == 4) {
                menu.viewTaskList(toDoList.getTasksList());
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
        }
    }
}
