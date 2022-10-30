package exceptions;

public class TaskNumberOutOfRangeException extends RuntimeException {

    public TaskNumberOutOfRangeException() {
        super("\nTask number does not exist!");
    }
}
