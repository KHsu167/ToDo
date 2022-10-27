package exceptions;

public class IllegalRemovalDetailsEnteredException extends RuntimeException {

    public IllegalRemovalDetailsEnteredException() {
        super("\nTitle entered incorrectly or does not exist!");
    }
}
