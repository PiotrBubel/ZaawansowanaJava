package exceptions;

/**
 * Created by Piotrek on 25.05.2016.
 */
public class UnsolvableBoardException extends Exception {
    public UnsolvableBoardException(String message) {
        super(message);
    }

    public UnsolvableBoardException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
