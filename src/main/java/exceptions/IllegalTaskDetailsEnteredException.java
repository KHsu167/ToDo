package exceptions;

public class IllegalTaskDetailsEnteredException extends  RuntimeException{

    public IllegalTaskDetailsEnteredException() {
        super("\nTask details entered incorrectly! \nExample: Finish exercise part 1, 10/30/2022");
    }
}
