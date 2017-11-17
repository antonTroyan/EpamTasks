package by.troyan.epam.task3.exception;

public class DataReadException extends Exception {

    public DataReadException() {
    }

    public DataReadException(String message) {
        super(message);
    }

    public DataReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataReadException(Throwable cause) {
        super(cause);
    }

    public DataReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
