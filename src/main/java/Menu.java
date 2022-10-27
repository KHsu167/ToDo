import java.util.List;
import java.util.Scanner;


public class Menu {

    private Task task;
    private final Scanner scanner = new Scanner(System.in);

    public void printMainMenu() {
        System.out.println();
        System.out.println("----ToDo Main Menu----");
        System.out.println("1: Create a task");
        System.out.println("2: Remove a task");
        System.out.println("3: Update a task");
        System.out.println("4: View task list");
        System.out.println("0: Exit");
        System.out.println();
    }

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    //TODO MIGHT FIX IT
    public String getStringResponseFromUserInput(String prompt) {
        String response = null;
        System.out.println(prompt);

        while (response == null) {
            response = scanner.nextLine();
            if (response == null) {
                System.out.println("Invalid entry. Please try again");
            }
        }
        return response;
    }

    public void viewTaskList(List<Task> tasksList) {
        System.out.println();
        for (int i = 0; i < tasksList.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + tasksList.get(i));
        }
    }
}
