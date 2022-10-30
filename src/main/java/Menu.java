import java.util.List;
import java.util.Scanner;


public class Menu {

    private final Scanner scanner = new Scanner(System.in);

    public void printMainMenu() {
        System.out.println();
        System.out.println("|  Task Manager  |");
        System.out.println();
        System.out.println("1: Create a task");
        System.out.println("2: Remove a task");
        System.out.println("3: Update a task");
        System.out.println("4: View task list");
        System.out.println("5: Change status to completed");
        System.out.println("0: Exit");
        System.out.println();
    }

//    public void updateMenu() {
//        System.out.println();
//        System.out.println("Which task would you like to update? (enter the number)");
//    }

    public void updateMenu2() {
        System.out.println();
        System.out.println("Enter...");
        System.out.println("1 to update description");
        System.out.println("2 to update deadline");
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

    public Integer getIntResponseFromUserInput(String prompt) {
        Integer response = null;

        while (response == null) {
            System.out.println(prompt);
            String responseAsString = scanner.nextLine().trim();
            try {
                response = Integer.parseInt(responseAsString);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a number!");
            }
        }
        return response;
    }

    public Integer getIntResponseWithNoPrompt() {
        Integer response = null;

        while (response == null) {
            String responseAsString = scanner.nextLine().trim();
            try {
                response = Integer.parseInt(responseAsString);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a number!");
            }
        }
        return response;
    }

    public void viewTaskList(List<Task> tasksList) {
        System.out.println();
        for (int i = 0; i < tasksList.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + tasksList.get(i));
        }
        if (tasksList.size() == 0) {
            System.out.println("\n*Task list is empty\n");
        }
    }
}
