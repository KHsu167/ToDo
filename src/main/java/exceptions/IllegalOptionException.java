package exceptions;

public class IllegalOptionException extends RuntimeException {
    public IllegalOptionException() {
        super("\nThat is not an option!");
    }
}
