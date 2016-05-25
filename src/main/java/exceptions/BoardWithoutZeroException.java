package exceptions;

/**
 * Created by Piotrek on 25.05.2016.
 */
public class BoardWithoutZeroException extends Exception {
    public BoardWithoutZeroException(String message) {
        super(message);
    }

    public BoardWithoutZeroException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
