package exceptions;

public class WrongImageFormatException extends Exception {
    public WrongImageFormatException(String message) {
        super(message);
    }

    public WrongImageFormatException(String message, Throwable throwable) {
        super(message, throwable);
    } 
}
